import math
for i in range(int(input())):
    x1,y1,r1,x2,y2,r2 = map(int,input().split())

    r1,r2 = [r1,r2] if r2 >= r1 else [r2,r1]
    d = math.sqrt(((x1-x2)**2) + ((y1-y2)**2))
    if r2 - r1 < d < r1 + r2:
        print(2)
    elif d == r1+r2:
        print(1)
    elif d == r2-r1 and d!= 0:
        print(1)
    elif d < r2-r1 or d > r1+r2:
        print(0)
    else:
        print(-1)
