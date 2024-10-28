# a,b -> 두 문자열의 편집거리(문자열a를 문자열 b로 바꾸기 위해 필요한 최소 연산 횟수)
# 하나의 문자를 삽입 or 특정 문자 삭제 or 다른 문자로 교환
import sys

a = list(map(str,sys.stdin.readline().rstrip()))
b = list(map(str,sys.stdin.readline().rstrip()))
dp = [[-1]*len(b) for _ in range(len(a))]

# 초기값 계산
if a[0]==b[0]: dp[0][0] = 0
else: dp[0][0] = 1
for i in range(1,len(a)):
    if a[i]==b[0]: dp[i][0] = i
    else: dp[i][0] = dp[i-1][0]+1
for j in range(1,len(b)):
    if a[0]==b[j]: dp[0][j] = j
    else: dp[0][j] = dp[0][j-1]+1

# 나머지 계산
for i in range(1,len(a)):
    for j in range(1,len(b)):
        if a[i]==b[j]:  # 같으면 편집거리 그대로
            dp[i][j] = dp[i-1][j-1]
        else:           # 다르면 삭제/추가(dp[i-1][j], dp[i][j-1]) or 교환(dp[i-1][j-1])
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1

print(dp[len(a)-1][len(b)-1])
  
