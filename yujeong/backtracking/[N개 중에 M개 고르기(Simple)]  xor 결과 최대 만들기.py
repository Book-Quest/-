# n개의 정수 중 m개의 숫자를 뽑아 xor한 결과
import sys
n,m = map(int,sys.stdin.readline().split())
number = list(map(int,sys.stdin.readline().split()))
answer = -1

def backtracking(res,num,k):
    global answer
    if num == m:
        answer = max(answer,res)
        return
    for i in range(k,n):
        backtracking(res^number[i],num+1,i+1)

backtracking(0,0,0)

print(answer)
