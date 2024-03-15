import sys
#sys.stdin = open("input.txt")
A,B,C = map(int,sys.stdin.readline().split())
arr = [0 for i in range(101)]
for i in range(3):
    start,end = map(int,sys.stdin.readline().split())
    for j in range(start,end):
        arr[j] +=1

ans = 0
for i in arr:
    if(i == 1):
        ans += A
    elif(i==2):
        ans += B*2
    elif(i==3):
        ans += C*3

print(ans)