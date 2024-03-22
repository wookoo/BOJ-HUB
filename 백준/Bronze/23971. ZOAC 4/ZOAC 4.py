import sys
import math
H,W,N,M = list(map(int,sys.stdin.readline().split()))
a = math.ceil(H/(N+1))
b = math.ceil(W/(M+1))
print(a*b)