import sys
#sys.stdin = open("input.txt")
a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
z = int(sys.stdin.readline())
print(1 if a+b <= z else 0)