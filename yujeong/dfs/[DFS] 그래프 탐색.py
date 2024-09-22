
import sys

n,m = map(int,sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [False]*(n+1)
count = 0
for _ in range(m):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    global count
    for i in graph[v]:
        if not visited[i]:
            visited[i] = True
            count += 1
            dfs(i)

visited[1] = True
dfs(1)
print(count)
