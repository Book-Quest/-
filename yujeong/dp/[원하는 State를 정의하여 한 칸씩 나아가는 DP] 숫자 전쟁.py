# (1) 더미 맨 위의 카드를 비교
    # 내 카드 < 상대 카드 -> 내 카드 점수 + 내 카드 버리기
    # 내 카드 == 상대 카드 -> 내 카드와 상대 카드 버리기
    # 내 카드 > 상대 카드 -> 점수 먹히고 상대 카드 버리기
# (2) 서로의 카드를 버림
# 케이스 -> 모든 경우를 다 테스트하여 최고 점수 구하기
    # 내 카드만 버리기 : 내 카드 < 상대 카드 (dp[i][j] + second[j])
    # 상대 카드만 버리기 : 내 카드 > 상대 카드
    # 카드 모두 버리기 : 내 카드==상대카드 or 서로 카드 버리기 (dp[i+1][j+1])
# dp[i][j] : 1이 i번째까지 버리고 2가 j번째까지 버릴 때의 최고점수
    # 모두 버리기 : dp[i+1][j+1] = dp[i][j]
    # 내 카드 > 상대 카드 (상대카드 버림) : dp[i+1][j] = dp[i][j]
    # 내 카드 < 상대 카드 (내 카드 버림) : dp[i][j+1] = dp[i][j] + second[j]

import sys

n = int(sys.stdin.readline())
first = [0] + list(map(int,sys.stdin.readline().split())) +[0]
second = [0] + list(map(int,sys.stdin.readline().split())) +[0]
dp = [[-1]*(n+2) for _ in range(n+2)]      # 1이 i, 2가 j일때의 최고 점수
dp[0][0] = 0

result = -1
for i in range(n+1):
    for j in range(n+1):
        if dp[i][j] == -1:
            continue
        # 카드 모두 버리기
        dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j])
        # 카드 전쟁
        if j<n and first[i+1] > second[j+1]:
            dp[i][j+1] = max(dp[i][j+1], dp[i][j]+second[j+1])
        elif i<n and first[i+1] < second[j+1]:
            dp[i+1][j] = max(dp[i+1][j], dp[i][j])
        result = max(result,dp[i][j])
        
        
print(result)
