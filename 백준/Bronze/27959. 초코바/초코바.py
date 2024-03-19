import sys
a,b = map(int,sys.stdin.readline().split())
a = a*100
if a >= b:
    print("Yes")
else:
    print("No")