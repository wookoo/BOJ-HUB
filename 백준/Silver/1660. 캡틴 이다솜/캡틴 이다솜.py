import sys
#sys.stdin = open("input.txt")

case = int(input())

flat = [0] #이거도 dp 테이블로 바꿔버리기
solid = [0] #이거도 dp 테이블로 바꿔버리기
flatResult = 0
solidResult = 0


for i in range(1,case+1):
    temp = flat[i-1] + i
    flatResult +=temp
    flat.append(temp)
    solidResult = solid[i-1] + flat[i]
    solid.append(solidResult)
    if(solidResult >= case):
        break

if(solid[-1] > case):
    solid.pop()
dp = [10000]*(case+1)
#for i in solid:
#    dp[i] = 1

for i in solid:
    dp[i] = 1
for i in range(1,case+1):
    for index in solid:
        if(index > i):
            break
        dp[i] = min(dp[i],dp[i-index]+1)

print(dp[-1])