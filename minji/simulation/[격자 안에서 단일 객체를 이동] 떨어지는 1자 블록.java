import java.io.*;
import java.util.*;

public class Main {
       public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        int max = -1;
        int[][] graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        outerLoop:
        for (int j = 0; j < n; j++) {
            for (int i = k; i < k + m; i++) {
                if (graph[j][i] == 1) {
                    if(max != -1){
                        break outerLoop;
                    } else {
                        break;
                    }
                } else {
                    if(i == k+m-1) {
                        max = Math.max(max, j);
                    }
                }
            }
        }
        for(int i = k; i<k+m; i++){
            graph[max][i] = 1;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]);
                if (j < graph[0].length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
