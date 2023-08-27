import sys
#sys.stdin = open("input.txt")
MAX = 100
grid = [[0]*MAX for i in range(MAX)]
targetX, targetY,target = map(int,input().split())
for i in range(3):
    line = list(map(int,input().split()))
    for j in range(3):
        grid[i][j] = line[j]

r = 3
c = 3
ans = -1
for time in range(101):
    # print(time)
    if(grid[targetX-1][targetY-1]==target):
       ans = time
    #    print(time)
       break

    tempR = r
    tempC = c
    if tempR >= tempC:
        for i in range(tempR):
            freq = {}
            for j in range(tempC):
                if not grid[i][j] in freq and grid[i][j] !=0:
                    freq[grid[i][j]] = 0
                if grid[i][j] != 0:
                    freq[grid[i][j]] +=1
            for j in range(MAX):
                grid[i][j] = 0
            
            arr = sorted(list(freq.items()) ,key= lambda x:[x[1],x[0]])
            for index,item in enumerate(arr):
                if(not index*2 < MAX):
                    break
                grid[i][index*2] = item[0]
                grid[i][index*2+1] =item[1]
            c = max(c,len(freq)*2)

    else:
        for i in range(tempC):
            freq = {}
            for j in range(tempR):
                if not grid[j][i] in freq and grid[j][i] !=0:
                    freq[grid[j][i]] = 0
                if(grid[j][i]!=0):
                    freq[grid[j][i]] +=1

            for j in range(MAX):
                grid[j][i] = 0
        
            arr = sorted(list(freq.items()) ,key= lambda x:[x[1],x[0]])
            for index,item in enumerate(arr):
                if(not index*2 < MAX):
                    break
                grid[index*2][i] = item[0]
                grid[index*2+1][i] =item[1]
            r = max(r,len(freq)*2)
   
print(ans)