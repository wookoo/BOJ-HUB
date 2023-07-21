import sys
from collections import deque
import copy


N,M = map(int,sys.stdin.readline().split())
MAP = [list(map(int,sys.stdin.readline().split())) for i in range(N)]

result = []
def bfs(MAP):
    temp_MAP = copy.deepcopy(MAP)
    q = deque()
    
    for i in range(N):
        for j in range(M):
            if(temp_MAP[i][j]) == 2:
                q.append((i,j))
    
    while q:
        nx,ny = q.popleft()
        
        for dx,dy in [[0,1],[0,-1],[1,0],[-1,0]]:
            cx = nx + dx
            cy = ny + dy
            
            if(0 <= cx <N and 0 <= cy <M and temp_MAP[cx][cy]==0):
                temp_MAP[cx][cy] = 2
                q.append([cx,cy])
                
    s = 0
    for i in range(N):
        for j in range(M):
            if(temp_MAP[i][j]) == 0:
                s += 1
                
    return s


def genMAP(wall):
    if(wall == 3):
        result.append(bfs(MAP))
        return
    for i in range(N):
        for j in range(M):
            if(MAP[i][j] == 0):
                MAP[i][j] = 1
                genMAP(wall+1)
                MAP[i][j] = 0
genMAP(0)
print(max(result))