import java.util.*;
import java.io.*;
public class Main {
    public static int[][] graph;

    private static int findCoin(int r, int c) {
        int count = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (graph[r+i][c+j]==1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n-2; i++) {
            for (int j=0; j<n-2; j++) {
                int count = findCoin(i,j);
                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}
