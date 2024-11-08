import java.io.*;
import java.util.*;

public class Main {
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

        // check-1 (시작점 초기화)
        dp[0][n-1] = grid[0][n-1];
        
        // check-2 (첫번째 행은 왼쪽으로만 이동할 수 있기 때문에 점화식 별개로 처리)
        for(int i=n-2; i>=0; i--){
            dp[0][i] = dp[0][i+1] + grid[0][i];
        }
        // check-3 (마지막 열은 아래로만 이동할 수 있기 때문에 점화식 별개로 처리)
        for (int i=1; i<n; i++) {
            dp[i][n-1] = dp[i-1][n-1] + grid[i][n-1];
        }

        for(int i=1; i<n; i++){
            for(int k=n-2; k>=0; k--){
                dp[i][k] = Math.min(dp[i-1][k] + grid[i][k], dp[i][k+1] + grid[i][k]);
            }
        }
        System.out.print(dp[n-1][0]);
    }
}
