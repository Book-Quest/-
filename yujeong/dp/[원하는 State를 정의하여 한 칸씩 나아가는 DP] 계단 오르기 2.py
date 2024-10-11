# 1 or 2계단씩 이동 가능 / 동전 쓰러가기
# 계단 이동 1계단 - 최대 3번
# n층까지 올라 때 얻을 수 있는 동전의 최대개수
import sys

n = int(sys.stdin.readline())
arr = [0] + list(map(int,sys.stdin.readline().split()))
dp = [[0]*(n+1) for _ in range(4)]
dp[1][1] = arr[1]
dp[0][2] = arr[2]

for i in range(4):
    for j in range(2,n+1):
        if i>=1 and dp[i-1][j-1] != 0:
            dp[i][j] = max(dp[i][j], dp[i-1][j-1]+arr[j])
        if dp[i][j-2] != 0:
            dp[i][j] = max(dp[i][j], dp[i][j-2]+arr[j])

result = 0
for i in range(4):
    result = max(dp[i][n], result)
print(result)
