
import sys

n = int(sys.stdin.readline())
graph = []
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
r,c = map(int,sys.stdin.readline().split())
r,c = r-1,c-1

# 폭탄
temp = [[0]*n for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
num = graph[r][c]

graph[r][c] = 0
for i in range(1,num):
    if r-i >= 0:
        graph[r-i][c] = 0
    if r+i < n:
        graph[r+i][c] = 0
    if c-i >= 0:
        graph[r][c-i] = 0
    if c+i < n:
        graph[r][c+i] = 0
    
    if r-i < 0 and r+i >= n and c-i < 0 and c+i >=n:
        break 

for j in range(n):
    tempR = n-1
    for i in range(n-1,-1,-1):
        if graph[i][j] != 0:
            temp[tempR][j] = graph[i][j]
            tempR -= 1

for i in range(n):
    print(*temp[i], sep=" ")
