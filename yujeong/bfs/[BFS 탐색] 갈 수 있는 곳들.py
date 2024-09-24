# 0-이동가능 / 1-이동불가능
import sys
from collections import deque

n,k = map(int,sys.stdin.readline().split())
graph = []
visited = [[False]*n for _ in range(n)]
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
count = 0

dx = [-1,1,0,0]
dy = [0,0,-1,1]
def bfs(x,y):
    global count
    queue = deque([])
    count += 1
    queue.append((x,y))
    visited[x][y] = True
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if not visited[nx][ny] and graph[nx][ny]==0:
                count += 1
                queue.append((nx,ny))
                visited[nx][ny] = True

for _ in range(k):
    r,c = map(lambda x:x-1,map(int,sys.stdin.readline().split()))
    if not visited[r][c] and graph[r][c] == 0:
        bfs(r,c)

print(count)
