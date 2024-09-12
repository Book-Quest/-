# 블럭 칸의 숫자 합이 최대

import sys

n,m = map(int,sys.stdin.readline().split())
answer = 0
graph = []

for i in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
    # 각 행에서 2번 count
    for j in range(m-2):
        s = sum(graph[i][j:j+3])
        answer = max(answer,s)


# 나머지 count
dx = [0,0,1,1,2]
dy = [-1,1,-1,1,0]
for j in range(m):
    for i in range(n-1):
        s = 0
        for k in range(5):
            nx = i+dx[k]
            ny = j+dy[k]
            if nx>=0 and nx<n and ny>=0 and ny<m:
                s = max(s,graph[nx][ny])
        s += graph[i][j] + graph[i+1][j]
        answer = max(answer,s)
        

print(answer)
