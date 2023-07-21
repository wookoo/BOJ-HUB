import sys
from collections import deque
num,t = map(int,sys.stdin.readline().split())
data = map(int,sys.stdin.readline().split())
q = deque(range(1,num+1))
move = 0

for i in data:        
    search = q.index(i)
    j = min(search,abs(len(q) - search))
    if(j == search and j!= 0):
        for _ in range(j):
            q.append(q.popleft())
    else:
        for _ in range(j):
            q.appendleft(q.pop())

    q.popleft()
    move += j
    

    
print(move)