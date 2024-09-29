# 가장 긴 증가 부분 수열의 길이
import sys

n = int(sys.stdin.readline())
input = list(map(int,sys.stdin.readline().split()))
dp = [1]*n

for i in range(1,n):
    for j in range(i):
        if input[i] > input[j]:
            dp[i] = max(dp[i],dp[j]+1)

print(max(dp))
