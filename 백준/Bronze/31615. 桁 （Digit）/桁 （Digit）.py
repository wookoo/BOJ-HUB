import sys
#sys.stdin = open("input.txt")
a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
temp = a+b
ans = 0
while(temp > 0):
    temp = temp //10
    ans += 1

print(ans)