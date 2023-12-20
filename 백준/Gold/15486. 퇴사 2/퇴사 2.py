import sys

N = int(sys.stdin.readline())
dp = [0]*(N+2)
T = [0]
P = [0]
temp_index = 0
temp_max = 0
for i in range(N):
    t,p = map(int,sys.stdin.readline().split())
    T.append(t)
    P.append(p)
    
for i in range(1,N+1):
    index_next = i +T[i]
    if(temp_max <= dp[i]):
        temp_max = dp[i]
        temp_index = i
    if(index_next <=N+1):
        if(index_next > temp_index):
            dp[index_next] = max(dp[index_next] ,temp_max+P[i])
        else:
            dp[index_next] = max(dp[index_next] ,dp[i]+P[i])
    
print(max(dp))