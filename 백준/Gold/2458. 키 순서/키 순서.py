import sys
import math
#sys.stdin = open("input.txt")


N,M = map(int,input().split())

cost = [[math.inf]*N for i in range(N)]
for _ in range(M):
    start,end = map(int,input().split())
    start -=1
    end -=1 
    cost[start][end] = 1



for i in range(N):
    cost[i][i] = 0



for k in range(N):
    for a in range(N):
        for b in range(N):
            cost[a][b] = min(cost[a][b], cost[a][k] + cost[k][b])


result = 0
for i in range(N):
    cnt = 0
    for j in range(N):
        if(cost[i][j] > cost[j][i] or cost[i][j] < cost[j][i]):
            cnt +=1
    if(cnt == N-1):
        result +=1

print(result)