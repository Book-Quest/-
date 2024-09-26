import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [[-1]*n for _ in range(n)]
sr,sc,er,ec = map(lambda x:x-1,map(int,sys.stdin.readline().split()))

dx = [-2,-1,1,2,2,1,-1,-2]
dy = [1,2,2,1,-1,-2,-2,-1]
def bfs(x,y):
    queue = deque([])
    queue.append((x,y))
    graph[x][y] = 0
    while queue:
        x,y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if graph[nx][ny]==-1:
                graph[nx][ny] = graph[x][y]+1
                queue.append((nx,ny))
                if nx==er and ny==ec:
                    return

bfs(sr,sc)
print(graph[er][ec])
