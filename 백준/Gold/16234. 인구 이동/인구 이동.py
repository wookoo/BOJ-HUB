import sys
#sys.stdin = open("input.txt")
from collections import deque
SIZE, low, high = map(int,input().split())
grid = [list(map(int,input().split())) for i in range(SIZE)]
flag = False
path = 0
while True:
    call = 0
    path +=1

    mark = [[0]*SIZE for i in range(SIZE)]
    q = deque()
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    cnt = 0
    for i in range(SIZE):
        for j in range(SIZE):

            for index in range(4):
                tx = i + dx[index]
                ty = j + dy[index]
                if(0 <= tx < SIZE and 0<= ty < SIZE and low <= abs(grid[i][j] - grid[tx][ty]) <= high and mark[tx][ty] ==0):
                    call += 1
                    q.append([i,j])
                    cnt+=1
                    temp = 0
                    visit = 0
                    while q:
                        nx,ny = q.popleft()
                        #차이나면 1
                        for index in range(4):
                            tx = nx + dx[index]
                            ty = ny + dy[index]
                            if(0 <= tx < SIZE and 0<= ty < SIZE and low <= abs(grid[nx][ny] - grid[tx][ty]) <= high and mark[tx][ty] ==0):
                                q.append([tx,ty])
                                
                                if(not mark[nx][ny] == cnt):
                                    mark[nx][ny] = cnt
                                if(not mark[tx][ty] == cnt):
                                    mark[tx][ty] = cnt
                    break

    dic = {i:[0,0] for i in range(cnt+1)}

    for i in range(SIZE):
        for j in range(SIZE):
            if(mark[i][j] == 0):
                continue
            dic[mark[i][j]][0] += grid[i][j]
            dic[mark[i][j]][1] +=1 


    for i in range(SIZE):
        for j in range(SIZE):
            if(mark[i][j] == 0):
                continue
            avg = int( dic[mark[i][j]][0] / dic[mark[i][j]][1])
            grid[i][j] = avg


    if(call == 0):
        break

print(path-1)