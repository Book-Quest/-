# 1~n까지의 수를 정확히 한번만 사용해서 만들 수 있는 가능한 모든 수열 (가장 뒤 수열부터 출력)
import sys

n = int(sys.stdin.readline())
arr = []
visited = [False]*(n+1)

def reversePerm(num):
    if num == n:
        print(*arr,sep=" ")
        return
    for i in range(n,0,-1):
        if not visited[i]:
            visited[i] = True
            arr.append(i)
            reversePerm(num+1)
            arr.pop()
            visited[i] = False

reversePerm(0)
