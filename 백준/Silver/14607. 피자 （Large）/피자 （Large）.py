import sys
#sys.stdin = open("input.txt")
size = int(sys.stdin.readline())
ans = size * (size-1) //2
print(int(ans))