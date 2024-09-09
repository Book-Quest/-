# 행복한 수열 : 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열
# 행복한 수열의 개수 구하기
import sys
n, m = map(int,sys.stdin.readline().split())
graph = []
result = 0
for i in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
    # 행의 행복한 수열
    count, pre = 0, 0
    for j in range(n):
        if graph[i][j] == pre:
            count += 1
        else:
            count = 1
            pre = graph[i][j]
        if count >= m:
            result += 1
            break

# 열의 행복한 수열
for j in range(n):
    count, pre = 0,0
    for i in range(n):
        if graph[i][j] == pre:
            count += 1
        else:
            count = 1
            pre = graph[i][j]
        if count >= m:
            result += 1
            break
print(result)
