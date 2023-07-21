import sys
from collections import deque


def bfs(x,y):
    arr[x][y] = 3
    q = deque()
    q.append((x,y))
    count = 0
    while q:
        x,y = q.popleft()
        
        for dx,dy in [(0,1),(1,0),(0,-1),(-1,0)]:
            nx = x + dx
            ny = y + dy
            
            if(0 <= nx < N and 0<= ny <M and arr[nx][ny]==1):
                arr[nx][ny] = 3
                q.append((nx,ny))
                count +=1
                
    return count
            


count = int(sys.stdin.readline())


for i in range(count):
    
    M,N,K = map(int,sys.stdin.readline().split())
    arr = [[0] *M for i in range(N)]

    for t in range(K):
        x,y = map(int,sys.stdin.readline().split())
        arr[y][x] = 1
    cnt = []
    for x in range(M):
        for y in range(N):
            if(arr[y][x] == 1):

                cnt.append(bfs(y,x))
                
    print(len(cnt))

