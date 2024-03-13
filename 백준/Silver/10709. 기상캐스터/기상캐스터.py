import sys
#sys.stdin = open("input.txt")

a,b = map(int,sys.stdin.readline().split())
arr = [list(sys.stdin.readline().strip()) for i in range(a)]
zeroIdx = []
for i in range(a):
    for j in range(b):
        if(arr[i][j] == 'c'):
            arr[i][j] = 0
            zeroIdx.append([i,j])
        else:
            arr[i][j] = -1

for x,y in zeroIdx:
    iter = 0
    for k in range(y+1,b):
        iter += 1
        if(arr[x][k] == -1):
            arr[x][k] = iter
        elif(arr[x][k] > iter):
            arr[x][k] = iter
        else:
            break

for i in arr:
    print(*i)