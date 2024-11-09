import java.io.*;
import java.util.*;

public class Main {
    // 시간복잡도: O(N^2)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                grid[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n][n];

        dp[0][0] = grid[0][0];
        
        for(int i=1; i<n; i++){
            dp[0][i] = Math.min(dp[0][i-1], grid[0][i]);
            dp[i][0] = Math.min(dp[i-1][0], grid[i][0]);
        }

        for(int i=1; i<n; i++){
            for(int k=1; k<n; k++){
                // check (최솟값 중 최대)
                dp[i][k] = Math.max(Math.min(dp[i-1][k], grid[i][k]), Math.min(dp[i][k-1], grid[i][k])); // sol-1
              //dp[i][k] = Math.min(Math.max(dp[i-1][k], dp[i][k-1]), grid[i][k]); // sol-2
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
