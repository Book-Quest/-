import sys

n,m = map(int,sys.stdin.readline().split())
graph = []
visited = [[False]*m for _ in range(n)]
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))

dx = [1,0]
dy = [0,1]
def dfs(x,y):
    for i in range(2):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx<0 or nx>=n or ny<0 or ny>=m:
            continue
        if graph[nx][ny]==1 and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(nx,ny)

dfs(0,0)
if visited[-1][-1]:
    print(1)
else:
    print(0)
