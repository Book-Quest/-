import java.util.*;
import java.io.*;

public class Main {
    public static int[][] graph;

    private int blockSum() {
        int sum = 0;

        return sum;
    }
    
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 2개 선택 후 나머지 1개 선택
        int[] dx = {-1,-1,1,1,0};
        int[] dy = {0,1,0,1,2};
        int sum;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m-1; j++) {
                sum = graph[i][j] + graph[i][j+1];
                for (int k=0; k<5; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if (nx<0 || nx>=n || ny>=m)
                        continue;
                    answer = Math.max(answer, sum+graph[nx][ny]);
                }
            }
        }

        // 세로 3개짜리 선택
        for (int j=0; j<m; j++) {
            for (int i=0; i<n-2; i++){
                sum = graph[i][j] + graph[i+1][j] + graph[i+2][j];
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}
