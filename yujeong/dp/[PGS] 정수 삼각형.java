// 꼭대기~바닥 경로 중 거쳐간 숫자의 합이 가장 큰 경우
// 아래칸 대각선으로만 이동 가능
import java.util.*;
class Solution {
    public static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        int r = triangle.length;
        int c = triangle[r-1].length;
        // DP 구하기
        dp = new int[r][c];
        dp[0][0] = triangle[0][0];
        for (int i=0; i<r-1; i++) {
            for (int j=0; j<triangle[i].length; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+triangle[i+1][j+1]);
            }
        }
            
        // 최대값 구하기
        for (int num:dp[r-1]) {
            answer = Math.max(answer,num);
        }
        return answer;
    }
}

//     0
//    0 1
//   0 1 2
//  0 1 2 3
// 0 1 2 3 4
