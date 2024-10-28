# dp[i][j] : 첫번째 문자열의 i번째 문자 , 두번째 문자열의 j번째 문자까지 고려했을 때의 최장 공통 수열 길이

import sys

a = list(map(str,sys.stdin.readline().rstrip()))
b = list(map(str,sys.stdin.readline().rstrip()))
dp = [[0]*len(b) for _ in range(len(a))]

# 초기값 계산
if a[0]==b[0]: dp[0][0]=1
for i in range(1,len(a)):
    if a[i]==b[0]:
        dp[i][0] = 1
    else:
        dp[i][0] = dp[i-1][0]
for j in range(1,len(b)):
    if a[0]==b[j]:
        dp[0][j] = 1
    else:
        dp[0][j] = dp[0][j-1]

            
# 나머지 계산
for i in range(1,len(a)):
    for j in range(1,len(b)):
        if a[i] == b[j]:
            dp[i][j] = dp[i-1][j-1]+1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[len(a)-1][len(b)-1])
