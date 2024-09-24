# 뱀X : 1 / 뱀o : 0
import sys
from collections import deque

n,m = map(int,sys.stdin.readline().split())
graph = []
visited = [[False]*m for _ in range(n)]
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))


dx = [-1,1,0,0]
dy = [0,0,-1,1]
def bfs(x,y):
    queue = deque([])
    queue.append((x,y))
    visited[x][y] = True
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if not visited[nx][ny] and graph[nx][ny]==1:
                queue.append((nx,ny))
                visited[nx][ny] = True

bfs(0,0)
if visited[-1][-1]:
    print(1)
else:
    print(0)
