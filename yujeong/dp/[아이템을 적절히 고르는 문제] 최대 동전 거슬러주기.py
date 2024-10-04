# n개의 동전의 종류 => 금액 m을 거슬러주기 위한 방법 중 가능한 최대 동전의 수를 구해주는 프로그램
# 같은 종류의 동전을 여러번 거슬러 줄 수 있음

import sys

n,m = map(int, sys.stdin.readline().split())
coins = list(map(int,sys.stdin.readline().split()))
dp = [-sys.maxsize]*(m+1)
dp[0] = 0

for i in coins:
    if i <= m:
        dp[i] = 1

for i in range(1,m+1):
    for j in coins:
        if i >= j:
            if dp[i-j] == -sys.maxsize:
                continue
            dp[i] = max(dp[i], dp[i-j]+1)

if dp[m]>0:
    print(dp[m])
else:
    print(-1)
