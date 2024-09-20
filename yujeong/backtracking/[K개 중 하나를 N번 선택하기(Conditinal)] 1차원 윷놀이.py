# 번호 1~m / 말 1~k번
# n번의 턴 - 이동 칸수
# 모든 경우의 수 구해서 최대값과 비교하기

import sys

n,m,k = map(int,sys.stdin.readline().split())
turn = list(map(int,sys.stdin.readline().split()))
loc = [1]*(k+1)
score = 0

def countScore():
    count = 0
    for l in loc:
        if l >= m:
            count += 1
    return count

def backtracking(t):
    global score
    if t == n:
        score = max(score,countScore())
        return
    for i in range(1,k+1):
        loc[i] += turn[t]
        backtracking(t+1)
        loc[i] -= turn[t]

backtracking(0)

print(score)
