# 1이상 k이하의 숫자를 하나 고르는 행위 n번 반복하여 나올 수 있는 모든 서로 다른 순서쌍 구하기

import sys

k,n = map(int,sys.stdin.readline().split())

def backtracking(arr, x):
    if x == n:
        print(*arr, sep=" ")
        return
    for i in range(1,k+1):
        backtracking(arr+[i], x+1)
    
backtracking([], 0)
