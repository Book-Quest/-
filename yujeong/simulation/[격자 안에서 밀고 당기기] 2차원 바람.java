// 특정 직사각형 영역의 경계 숫자를 시계방향으로 한칸씩 shift
// 직사각형 영역에 있는 값들을 자신의 위치를 기준으로 자기자신+인접한 원소들의 평균값(버림)으로 변경

import java.util.*;
import java.io.*;

public class Main {
    public static int n,m;
    public static int[][] graph;
    public static int[] dx = {-1,1,0,0}, dy={0,0,-1,1};

    private static void rotate(int r1, int c1, int r2, int c2) {
        int temp = graph[r1][c2];
        // r1
        for(int j=c2; j>c1; j--)
            graph[r1][j] = graph[r1][j-1];
        // c1
        for (int i=r1; i<r2; i++)
            graph[i][c1] = graph[i+1][c1];
        // r2
        for (int j=c1; j<c2; j++)
            graph[r2][j] = graph[r2][j+1];
        // c2
        for (int i=r2; i>r1+1; i--)
            graph[i][c2] = graph[i-1][c2];
        graph[r1+1][c2] = temp;
    }

    private static void setAvgVal(int r1, int c1, int r2, int c2) {
        int[][] newGraph = new int[n][m];
        int sum,count;
        for (int i=r1; i<=r2; i++) {
            for (int j=c1; j<=c2; j++) {
                sum = graph[i][j];
                count = 1;
                for(int k=0; k<4; k++) {
                    int ni = i+dx[k];
                    int nj = j+dy[k];
                    if (ni<0 || ni>=n || nj<0 || nj>=m)
                        continue;
                    sum += graph[ni][nj];
                    count++;
                }
                newGraph[i][j] = sum/count;
            }
        }

        for(int i=r1; i<=r2; i++) {
            for (int j=c1; j<=c2; j++) {
                graph[i][j] = newGraph[i][j];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        // 바람
        int r1,c1,r2,c2;
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken())-1;
            c1 = Integer.parseInt(st.nextToken())-1;
            r2 = Integer.parseInt(st.nextToken())-1;
            c2 = Integer.parseInt(st.nextToken())-1;
            rotate(r1,c1,r2,c2);
            setAvgVal(r1,c1,r2,c2);
        }

        // 출력
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
