# 1~N 숫자 중 M개를 골라 만들 수 있는 조합
import sys

n,m = map(int,sys.stdin.readline().split())
arr = []

def backtracking(num,k):
    if num==m:
        print(*arr, sep=" ")
        return
    for i in range(k,n+1):
        arr.append(i)
        backtracking(num+1,i+1)
        arr.pop()

backtracking(0,1)
