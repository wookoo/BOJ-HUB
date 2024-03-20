import sys
#sys.stdin = open("input.txt")
x,y,tx,ty = map(int,sys.stdin.readline().split())
print(min([abs(tx-x),x,y,abs(ty-y)]))