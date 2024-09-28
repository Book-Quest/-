# 오른쪽, 밑
# d[i][j] = max(d[i-1][j],d[i][j-1])

import sys

n = int(sys.stdin.readline())
graph = []
dp = []
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
    dp.append([0]*n)

# 초기 조건
dp[0][0] = graph[0][0]
for i in range(1,n):
    dp[i][0] = dp[i-1][0] + graph[i][0]
    dp[0][i] = dp[0][i-1] + graph[0][i]

# 나머지
for i in range(1,n):
    for j in range(1,n):
        dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + graph[i][j]

# 최대 숫자 합
print(dp[-1][-1])
