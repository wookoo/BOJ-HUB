import sys
from collections import deque
count = int(sys.stdin.readline())
for i in range(count):
    total,find = map(int,sys.stdin.readline().split())
    
    q = deque(zip(map(int,sys.stdin.readline().split()),range(total)))
    count = 0
    while q:
        temp = [i[0] for i in q]
        #print(max(temp))
        if(max(temp) == q[0][0]):
            count +=1
            temp = q.popleft()
            #print(temp,find)
            if(temp[1] == find):
                print(count)
                break
        else:
            t = q.popleft()
            q.append(t)