# n개의 옷 + m일동안 적절히 -> 만족도 합 최대
# 만족도의 합 : m개의 날 중 인접한 날짜에 입은 옷의 화려함의 차이의 합
# 시작 날짜, 마지막 날짜, 옷의 화려함

import sys

n,m = map(int,sys.stdin.readline().split())
cloth = []
day = []
dp = [[-sys.maxsize]*n for _ in range(m)]
for i in range(n):
    s,e,v = map(int,sys.stdin.readline().split())
    day.append((s,e))
    cloth.append(v)
    if s <= 1 <= v:
        dp[0][i] = 0

for i in range(1,m):    # 날짜 (dp:i~i+1차이합, 현재 날짜 i+1일)
    for j in range(n):  # 현재 옷
        if day[j][0] <= i+1 <= day[j][1]:   # 현재 날짜(i+1일)
            for k in range(n):      # 이전 옷
                if dp[i-1][k] == -sys.maxsize:
                    continue
                dp[i][j] = max(dp[i][j], dp[i-1][k]+abs(cloth[k]-cloth[j]))

print(max(dp[m-1]))

# dp[i][j] = max_k<n(dp[i][j],dp[i-1][j] + abs(cloth[k]-cloth[j]))
# dp[i][j] : i번 차례(i-1번까지 수행) + j번 포함

# i : 0~m-1
# 0 - 초기
# 1 - 1-2일
# 2 - 2-3일
# 3 - 3-4일
