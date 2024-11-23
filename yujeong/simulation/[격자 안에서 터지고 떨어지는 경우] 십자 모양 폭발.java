// 선택한 위치의 값이 십자 모양의 크기
import java.util.*;
import java.io.*;
public class Main {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[][] newGraph = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        
        // 풀이
        int t = graph[r][c];
        // 폭탄 터트리기
        graph[r][c] = 0;
        int nr,nc;
        for (int i=1; i<t; i++) {
            for (int j=0; j<4; j++) {
                nr = r + dx[j]*i;
                nc = c + dy[j]*i;
                if (nr<0 || nr>=n || nc<0 || nc>=n)
                    continue;
                graph[nr][nc] = 0;
            }
        }
        // 아래로 떨어지기
        int idx;
        for(int j=0; j<n; j++) {
            idx = n-1;
            for (int i=n-1; i>=0 ;i--) {
                if (graph[i][j]!=0) {
                    newGraph[idx--][j] = graph[i][j];
                }
            }
        }
        // 출력
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(newGraph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
