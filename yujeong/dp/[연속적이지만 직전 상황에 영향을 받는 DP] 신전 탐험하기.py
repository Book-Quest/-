# n층 - 왼,가,오 중 1개의 방의 보물만 가져갈 수 있음
# 직전층과는 다른 방으로 들어가기
# 1~n올라가되 최대한 많은 보물 구하기

import sys
n = int(sys.stdin.readline())
room = [[]]
for _ in range(n):
    room.append(list(map(int,sys.stdin.readline().split())))
dp = [[-sys.maxsize]*3 for _ in range(n+1)]
dp[0] = [0,0,0]

for i in range(1,n+1):  # i층
    for j in range(3):  # 현재 방
        for k in range(3):  # 이전 방
            if j == k or dp[i-1][k] == -sys.maxsize:
                continue
            dp[i][j] = max(dp[i][j], dp[i-1][k] + room[i][j])
            

print(max(dp[n]))
