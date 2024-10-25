# 길이가 1인 계단수 (인접한 수 차이가 모두 1인 수)

import sys

n = int(sys.stdin.readline())
dp = [[0]*10 for _ in range(n+1)]
for i in range(1,10):
    dp[1][i] = 1

for i in range(2,n+1):
    dp[i][0] = dp[i-1][1]
    dp[i][9] = dp[i-1][8]
    for j in range(1,9):
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

print(sum(dp[n])%(10**9+7))


# 1 0/2
# 2 1/3
# 3 2/4
# 4 3/5
# 5 4/6
# 6 5/7
# 7 6/8
# 8 7/9
# 9 8
