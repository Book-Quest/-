# 2*n번 수행 -> 빨/파 중 하나 선택해서 빨강 n개, 파랑 n개 -> 뽑힌 숫자들의 합이 최대

import sys
n = int(sys.stdin.readline())
arr = []
for _ in range(2*n):
    arr.append(list(map(int,sys.stdin.readline().split())))

# 초기값
dp = [[-sys.maxsize]*(2*n) for _ in range(n+1)]  # dp[i][j] : 빨간색이 i개일 때 최대합
dp[0][0] = arr[0][1]
dp[1][0] = arr[0][0]

for i in range(n+1):
    for j in range(2*n-1):
        if dp[i][j] == -sys.maxsize:
            continue
        dp[i][j+1] = max(dp[i][j] + arr[j+1][1], dp[i][j+1])     # 파 선택
        if i < n:
            dp[i+1][j+1] = max(dp[i][j] + arr[j+1][0], dp[i+1][j+1]) 
        

print(dp[n][2*n-1])


# dp[i][j] = dp[i][j-1] + arr[j][1]   # 파 선택
# dp[i][j] = dp[i-1][j-1] + arr[j][0]   # 빨 선택
