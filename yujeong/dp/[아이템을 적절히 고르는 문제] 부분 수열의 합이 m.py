import sys

n,m = map(int,sys.stdin.readline().split())
coins = list(map(int,sys.stdin.readline().split()))
dp = [sys.maxsize]*(m+1)
dp[0] = 0

for i in range(n):
    for j in range(m,0,-1):
        if j >= coins[i]:
            if dp[j-coins[i]] == sys.maxsize:
                continue
            dp[j] = min(dp[j], dp[j-coins[i]]+1)

if dp[m] == sys.maxsize:
    print(-1)
else:
    print(dp[m])
