import sys
from collections import deque
import copy


N = int(sys.stdin.readline())
MAP = [list(sys.stdin.readline().strip()) for i in range(N)]


def bfs(x,y):
    q = deque()
    q.append((x,y))
    COLOR = MAP[x][y]
    while q:
        cx,cy = q.popleft()
        for dx,dy in [(1,0),(0,1),(-1,0),(0,-1)]:
            nx = cx + dx
            ny = cy + dy
            if( 0<= nx < N and 0 <= ny < N and  MAP[nx][ny] == COLOR):
                MAP[nx][ny] = 0
                q.append((nx,ny))
                
def bfs_2(x,y):
    q = deque()
    q.append((x,y))
    COLOR = temp_MAP[x][y]
    while q:
        cx,cy = q.popleft()
        for dx,dy in [(1,0),(0,1),(-1,0),(0,-1)]:
            nx = cx + dx
            ny = cy + dy
            if( 0<= nx < N and 0 <= ny < N ):
                if temp_MAP[nx][ny] == COLOR or (temp_MAP[nx][ny] == 'R' and COLOR == 'G') or \
                (temp_MAP[nx][ny] == 'G' and COLOR == 'R'): 
                    temp_MAP[nx][ny] = 0
                    q.append((nx,ny))

temp_MAP = copy.deepcopy(MAP)
call = 0
for i in range(N):
    for j in range(N):
        if(MAP[i][j] != 0):
            call +=1 
            bfs(i,j)

call_2 = 0
for i in range(N):
    for j in range(N):
        if(temp_MAP[i][j] != 0):
            
            call_2 +=1
            bfs_2(i,j)

print(call,call_2)