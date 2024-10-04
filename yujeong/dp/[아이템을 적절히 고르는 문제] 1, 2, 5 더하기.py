# 정수 n을 1,2,5의 합으로 나타내는 방법의 수 (순서가 다르면 다른 조합)
import sys

n = int(sys.stdin.readline())
dp = [0]*(n+1)
dp[1] = 1
dp[2] = 1
dp[5] = 1

for i in range(1,n+1):
    for j in (1,2,5):
        if i-j >=0:
            dp[i] = (dp[i] + dp[i-j]) % 10007

print(dp[n])
