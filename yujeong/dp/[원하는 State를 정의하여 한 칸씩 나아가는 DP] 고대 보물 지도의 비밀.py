import sys

n,k = map(int,sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))
dp = [[0]*n for _ in range(k+1)]

# 초기조건 (처음)
if arr[0] >= 0:
  dp[0][0] = arr[0]
else:
  dp[1][0] = arr[0]
answer = arr[0]

# 양수만 있는 경우
for j in range(1,n):
  if arr[j] >= 0:
    dp[0][j] = max(dp[0][j-1],0)+arr[j]
    answer = max(answer, dp[0][j])


for j in range(1,n):
  for i in range(1,k+1):
    if arr[j] >= 0:
      dp[i][j] = max(dp[i][j-1]+arr[j],arr[j])
    else:
      dp[i][j] = max(dp[i-1][j-1]+arr[j],arr[j])
    answer = max(answer,dp[i][j])

print(answer)


#  8 -3 3 -1 7
#0|8  0 3  0 7
#1|0  5 8  2 9
#2|0  0 0  7 14