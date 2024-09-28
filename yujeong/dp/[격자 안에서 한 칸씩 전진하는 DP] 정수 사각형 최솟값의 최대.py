# 오른쪽, 아래로 이동할 때 거쳐간 경로의 숫자 중 최솟값
# 여러 경로의 최솟값 중 최대값 구하기
# dp[i][j] = min(max(dp[i-1][j], dp[i][j-1]), graph[i][j])
import sys

n = int(sys.stdin.readline())
graph = []
dp = [] # 해당 위치까지의 경로 중 최소값을 저장
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
    dp.append([0]*n)

# 초기 조건
dp[0][0] = graph[0][0]
for i in range(1,n):
    dp[i][0] = min(dp[i-1][0], graph[i][0])
    dp[0][i] = min(dp[0][i-1], graph[0][i])

# 나머지
for i in range(1,n):
    for j in range(1,n):
        dp[i][j] = min(max(dp[i-1][j], dp[i][j-1]), graph[i][j])

print(dp[n-1][n-1])


# 예시
# min(상좌의 최대값,현재숫자) 
# 5 2 2
# 3 2 1
# 1 2 2

# 4 3 2
# 3 3 3
# 3 2 3
