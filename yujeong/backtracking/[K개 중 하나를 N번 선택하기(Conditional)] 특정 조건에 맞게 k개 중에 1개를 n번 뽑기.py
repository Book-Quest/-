# 1이상 k이하의 숫자를 n번 골라 서로 다른 순서쌍 구하기
import sys

k,n = map(int,sys.stdin.readline().split())

def backtracking(arr):
    if len(arr) == n:
        print(*arr,sep=" ")
        return
    for i in range(1,k+1):
        if len(arr)>=2 and arr[-1]==i and arr[-2]==i:
            continue
        backtracking(arr+[i])

backtracking([])
