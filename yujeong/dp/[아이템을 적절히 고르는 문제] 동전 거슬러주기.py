# dp[i] = max(dp[i],dp[i-coins[j]]+1)

import sys

n,m = map(int,sys.stdin.readline().split())
coins = list(map(int,sys.stdin.readline().split()))
dp = [sys.maxsize]*(m+1)
dp[0] = 0

for i in range(1,m+1):
    for j in range(n):
        if i >= coins[j]:
            if dp[i-coins[j]] == sys.maxsize:
                continue

            dp[i] = min(dp[i], dp[i-coins[j]]+1)

if dp[m] == sys.maxsize:
    print(-1)
else:
    print(dp[m])
