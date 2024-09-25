# 뱀X-1 / 뱀o-0
import sys
from collections import deque

n,m = map(int,sys.stdin.readline().split())
graph = []
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]
def bfs(x,y):
    queue = deque([])
    queue.append((x,y))
    graph[x][y] = 0
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = graph[x][y]+1

bfs(0,0)

if graph[-1][-1]!=1:
    print(graph[-1][-1])
else:
    print(-1)
