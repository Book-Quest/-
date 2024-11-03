import java.io.*;
import java.util.*;

public class Main {
    // check-1 (시간복잡도: O(N^2))
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                grid[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        // solution-1 (2차원 배열 dp 풀이)
        int[][] dp = new int[n][n];

        // check-2 (행 또는 열이 0인 case -> 다른 점화식 적용이 필요하므로 따로 초기화)
        dp[0][0] = grid[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i=1; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i=1; i<n; i++){
            for(int k=1; k<n; k++){
                dp[i][k] = Math.max(dp[i-1][k] + grid[i][k], dp[i][k-1] + grid[i][k]);
            }
        }
        System.out.print(dp[n-1][n-1]);

      // solution-2 (1차원 배열 dp 풀이 -> 각 셀을 계산할 때 오직 직전의 행과 열만 필요하므로 1차원 배열을 사용하여 공간 복잡도 개선 가능)
      int[] dp = new int[n];

        dp[0] = grid[0][0];
        for (int i=1; i>n; i++) {
           // check-3 (행이 0일 때 초기화)
            dp[i] = dp[i-1] + grid[0][i];
        }

        for (int i=1; i<n; i++) {
            // check-4 (열이 0일 때 초기화)
            dp[0] += grid[i][0];
            for (int k=1; k<n; k++) {
                dp[k] = Math.max(dp[k], dp[k-1]) + grid[i][k];
            }
        }

        System.out.print(dp[n-1]);
      
    }
}
