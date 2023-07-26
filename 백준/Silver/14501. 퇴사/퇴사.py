import sys
#sys.stdin = open("input.txt")
size = int(input())
N = [0]*size
P = [0]*size
cost = [0]*(size+1)
for i in range(size):
    t,j = map(int,input().split())
    N[i] = t
    P[i] = j



for i in range(size):
    endTime = N[i]
    endCost = P[i]
    for j in range(i+endTime,size+1):
        cost[j] = max(cost[j],endCost+cost[i])




print(cost[-1])
