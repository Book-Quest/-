class Solution {
    public int solution(String[] arr) {
        int n = arr.length / 2 + 1;
        int[] num = new int[n];
        int[] op = new int[n - 1];
        int numIndex = 0, opIndex = 0;

        // 수와 연산자를 분리하여 배열에 저장
        for (String cur : arr) {
            if (cur.equals("+")) 
                op[opIndex++] = '+';
            else if (cur.equals("-"))
                op[opIndex++] = '-';
            else 
                num[numIndex++] = Integer.parseInt(cur);
        }

        // DP 배열 초기화
        // dp[i][j][0] : i부터 j까지의 최소값
        // dp[i][j][1] : i부터 j까지의 최대값
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[i][i][0] = dp[i][i][1] = num[i];
        }

        // DP 계산
        for (int len = 1; len < n; len++) {
            for (int s = 0; s < n - len; s++) {
                int e = s + len;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = s; i < e; i++) {
                    if (op[i] == '+') {
                        max = Math.max(max, dp[s][i][1] + dp[i + 1][e][1]);
                        min = Math.min(min, dp[s][i][0] + dp[i + 1][e][0]);
                    } else {
                        max = Math.max(max, dp[s][i][1] - dp[i + 1][e][0]);
                        min = Math.min(min, dp[s][i][0] - dp[i + 1][e][1]);
                    }
                }

                dp[s][e][0] = min;
                dp[s][e][1] = max;
            }
        }

        return dp[0][n - 1][1];
    }
}
