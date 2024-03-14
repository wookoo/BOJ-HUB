import sys
#sys.stdin = open("input.txt")
a = int(sys.stdin.readline())
for i in range(a):

    print(sum(list(map(int,sys.stdin.readline().split()))))