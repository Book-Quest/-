class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            int x = puddle[1] - 1, y = puddle[0] - 1; // x 좌표 (열)
            dp[x][y] = -1; // 물웅덩이 표시
        }
      
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; // 물웅덩이는 0으로 설정하여 경로 배제
                    continue;
                }

                // 위쪽에서 오는 경로
                if (i > 0 && dp[i - 1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;

                // 왼쪽에서 오는 경로
                if (j > 0 && dp[i][j - 1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n - 1][m - 1];
    }
}
