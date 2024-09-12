import sys

n,t = map(int,sys.stdin.readline().split())
graph = []
for _ in range(2):
    graph.append(list(map(int,sys.stdin.readline().split())))

for _ in range(t):
    ltemp, rtemp = graph[1][n-1], graph[0][n-1]
    for i in range(n-1,0,-1):
        graph[0][i] = graph[0][i-1]
        graph[1][i] = graph[1][i-1]
    graph[0][0], graph[1][0] = ltemp,rtemp

for i in range(2):
    print(*graph[i],sep=" ")
