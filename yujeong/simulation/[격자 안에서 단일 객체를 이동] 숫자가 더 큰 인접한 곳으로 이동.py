import sys

n,r,c = map(int,sys.stdin.readline().split())
r, c = r-1, c-1
graph = []
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))

dr = [-1,1,0,0]
dc = [0,0,-1,1]
print(graph[r][c],end=" ")
while True:
    tempR,tempC = r,c
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < n and 0 <= nc < n:
            if graph[nr][nc] > graph[r][c]:
                print(graph[nr][nc],end=" ")
                r,c = nr,nc
                break
    if r==tempR and c==tempC:
        break
