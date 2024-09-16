# 1부터 n*n 위치까지 상하좌우대각선에 인접한 칸 중 가장 큰 숫자와 교환 : m번 수행

import sys

n,m = map(int,sys.stdin.readline().split())
graph = []
loc = [() for _ in range(n*n+1)]        # 각 숫자의 위치 좌표를 저장하는 배열
for i in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
    for j in range(n):
        loc[graph[i][j]] = (i,j)

dx = [-1,-1,0,1,1,1,0,-1]
dy = [0,1,1,1,0,-1,-1,-1]
def findMaxVal(x,y):
    maxVal = 0
    maxX, maxY = -1,-1
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<n and 0<=ny<n:
            if graph[nx][ny] > maxVal:
                maxVal = graph[nx][ny]
                maxX, maxY = nx, ny
    return maxX, maxY

for _ in range(m):
    for i in range(1,n*n+1):
        x, y = loc[i]
        nx, ny = findMaxVal(x,y)
        loc[i], loc[graph[nx][ny]] = (nx,ny), (x,y)
        graph[x][y], graph[nx][ny] = graph[nx][ny], graph[x][y]

for i in range(n):
    print(*graph[i], sep=" ")
