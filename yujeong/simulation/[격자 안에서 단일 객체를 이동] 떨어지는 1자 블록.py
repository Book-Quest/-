# k ~ k+m-1번째 열 => 가장 위에서부터 밑으로 떨어지고 격자 위 블럭과 맞닿으면 정지
import sys

n,m,k = map(int,sys.stdin.readline().split())
k -= 1
graph = []
stop = -1       # 격자 위 가장 상단 블럭 행
for i in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))
    # 격자 위 가장 상단 블럭 위치 구하기 (블럭과 맞닿은 위치)
    if stop == -1:
        for j in range(k,k+m):
            if graph[i][j] == 1:
                stop = i
                break
        # 바닥까지 블럭이 없는 행
        if i == n-1:
            stop = n       

# 블럭이 떨어진 후 상태
if stop != -1:
    for j in range(k,k+m):
        graph[stop-1][j]=1
# 출력
for i in range(n):
    print(*graph[i],sep=" ")
