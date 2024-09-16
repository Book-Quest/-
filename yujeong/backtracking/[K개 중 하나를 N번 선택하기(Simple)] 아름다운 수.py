# 1~4 숫자로만 이루어져있고 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자 개수 세기
    # 1이 1번, 2가 2번, 3이 3번, ...
    # n자리 아름다운 수

import sys
n = int(sys.stdin.readline())
count = 0

def backtracking(x):
    global count
    if x == n:
        count += 1
        return
    if x > n:
        return
    for i in range(1,5):
        backtracking(x+i)

backtracking(0)
print(count)
