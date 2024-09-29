# 시작 위치에서 최대 몇번 점프 가능한지
# 숫자범위에서 가능한 최대 점프 횟수 : 999번
import sys

n = int(sys.stdin.readline())
array = list(map(int,sys.stdin.readline().split()))
dp = [-1000]*n
dp[0] = 0

for i in range(1,n):
    for j in range(i):
        if array[j] == 0:
            continue
        if array[j]+j >= i:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))
