# 상하좌우 인접한 곳 중 가장 큰 값이 있는 곳으로 이동
import sys

n,m,t = map(int,sys.stdin.readline().split())
graph = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
loc = [tuple(map(lambda x:x-1, map(int,sys.stdin.readline().split()))) for _ in range(m)]
count = [[0]*n for _ in range(n)]

# 상하좌우 칸 중 최대값 위치 찾기
dx = [-1,1,0,0]
dy = [0,0,-1,1]
def findMaxValLoc(x,y):
    maxVal = 0
    maxX, maxY = -1,-1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if graph[nx][ny] > maxVal:
                maxVal = graph[nx][ny]
                maxX, maxY = nx, ny
    return maxX, maxY

new_loc = []
for _ in range(t):
    # 현재 위치에서 최대값 위치로 이동하기
    while loc:
        x,y = loc.pop()
        maxX, maxY = findMaxValLoc(x,y)
        count[maxX][maxY] += 1
        new_loc.append((maxX,maxY))
    # 이동 위치에서 동일한 위치의 구슬 없애기
    while new_loc:
        x,y = new_loc.pop()
        if count[x][y] == 1:
            loc.append((x,y))
        count[x][y] = 0


print(len(loc))
