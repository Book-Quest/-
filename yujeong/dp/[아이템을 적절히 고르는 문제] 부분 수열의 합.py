import sys

n,m = map(int,sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))

# 각 숫자를 포함한 부분수열의 합
dp = [[False]*(m+1) for _ in range(n+1)]
for i in range(n+1):
    dp[i][0] = True

for i in range(1,n+1):  # dp배열을 위한 인덱스(arr배열은 i-1)
    for j in range(1,m+1):
        if j >= arr[i-1]:
            dp[i][j] = dp[i-1][j] or dp[i-1][j-arr[i-1]]
        else:
            dp[i][j] = dp[i-1][j]
            

if dp[n][m]:
    print('Yes')
else:
    print('No')