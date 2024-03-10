import sys
#sys.stdin = open("input.txt")

N,A,B = map(int,sys.stdin.readline().split())
if( A== B):
    print("Anything")
elif( A < B):
    print("Bus")
else:
    print("Subway")