# 마름모 모양으로 1번만 채굴 가능 (영역을 벗어난 채굴도 가능)
    # 마름모 모양 : 중심점을 기준으로 k번 이내에 상하좌우 인접한 곳 (k=0은 한점만, 상하좌우 k번)
    # 중심점은 그래프 내에 있을 때(밖은 안인 경우 내에서 처리 가능)
# 채굴 비용 : 마름모 안의 격자 개수 => K*K + (K+1)*(K+1)
# 금 1개 가격 M -> 손해보지 않고 채굴할 수 있는 가장 많은 금의 개수
    # 금 개수*m >= 채굴 비용
# Tip) n의 홀짝에 따라 최대 k값을 구분해서 생각해야함

import sys

answer = 0      # 손해를 보지 않으면서 채굴할 수 있는 가장 많은 금의 개수
n,m = map(int,sys.stdin.readline().split())
graph =[]
for _ in range(n):
    graph.append(list(map(int,sys.stdin.readline().split())))

# 마름모 크기별 손해보지 않고 채굴하는 금 개수의 최대값을 구하는 함수
dx, dy = [-1,1,0,0], [0,0,-1,1]
dx2, dy2 = [-1,-1,1,1], [-1,1,-1,1]
def calGoldCount(x,y):
    count = 0               # 현재 금의 개수
    maxCount = 0            # 손해보지 않고 채굴하는 금 개수 최대값
    # 마름모 크기 k 0 (채굴 비용 1)
    price = 1               # 채굴 비용
    if graph[x][y] == 1:
        count = 1           
        maxCount = count    
    # 마름모 크기 k 1이상
    for k in range(1,n//2*2+1):
        price = k*k + (k+1)*(k+1)
        # 중심에서 상하좌우 k거리만큼 떨어진 칸
        for i in range(4):
            nx = x + dx[i]*k
            ny = y + dy[i]*k
            if 0<=nx<n and 0<=ny<n and graph[nx][ny]==1:
                count += 1
        # 중심에서 i, k-i만큼 떨어진 칸
        for i in range(1,k):
            for j in range(4):
                nx = x + dx2[j]*i
                ny = y + dy2[j]*(k-i)
                if 0<=nx<n and 0<=ny<n and graph[nx][ny]==1:
                    count += 1
        # 손해보지 않고 채굴하는 금 개수 최대값 계산
        if count*m >= price:
            maxCount = max(maxCount, count)


    return maxCount
            
# 중심점 기준으로 계산
for i in range(n):
    for j in range(n):
        # 마름모 크기별 손해보지 않고 채굴하는 금 개수의 최대값
        answer = max(answer, calGoldCount(i,j))
        
print(answer)

