import sys

n = int(sys.stdin.readline())
graph = []
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))

result = 0
for i in range(n-2):
    for j in range(n-2):
        temp = 0
        for k in range(3):
            temp += sum(graph[i+k][j:j+3])
        result = max(temp,result)

print(result)
