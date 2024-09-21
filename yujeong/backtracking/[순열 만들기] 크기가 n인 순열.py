# 1~n까지의 수를 한번만 사용해서 만들 수 있는 모든 수열
import sys

n = int(sys.stdin.readline())
arr = []
visited = [False]*(n+1)

def permutation(num):
    if num == n:
        print(*arr, sep=" ")
        return
    for i in range(1,n+1):
        if not visited[i]:
            visited[i] = True
            arr.append(i)
            permutation(num+1)
            arr.pop()
            visited[i] = False

permutation(0)
