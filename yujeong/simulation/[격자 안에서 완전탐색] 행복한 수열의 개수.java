// 행복한 수열 : 연속해서 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열 (존재하기만 하면 됨)
import java.util.*;
import java.io.*;
public class Main {
    public static int[][] graph;

    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count; int pre;
        // 가로
        for (int i=0; i<n; i++) {
            count = 0;
            pre = 0;
            for (int j=0; j<n; j++) {
                if (graph[i][j] == pre)
                    count++;
                else {
                    pre = graph[i][j];
                    count = 1;
                }
                if (count>=m){
                    answer++;
                    break;
                }

            }    
        }

        // 세로
        for (int j=0; j<n; j++) {
            count = 0;
            pre = 0;
            for (int i=0; i<n; i++) {
                if (graph[i][j] == pre)
                    count++;
                else {
                    pre = graph[i][j];
                    count = 1;
                }
                if (count>=m) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
