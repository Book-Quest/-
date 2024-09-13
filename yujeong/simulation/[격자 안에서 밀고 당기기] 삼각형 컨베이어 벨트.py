import sys

n,t = map(int,sys.stdin.readline().split())
graph = []      # 0~n-1 / n ~ 2n-1 / ...
for _ in range(3):
    graph += list(map(int,sys.stdin.readline().split()))

for _ in range(t):
    temp = graph[-1]
    for i in range(3*n-1,0,-1):
        graph[i] = graph[i-1]
    graph[0] = temp

print(*graph[0:n],sep=" ")
print(*graph[n:2*n],sep=" ")
print(*graph[2*n:3*n],sep=" ")
