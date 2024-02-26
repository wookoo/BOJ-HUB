import sys
from itertools import permutations

#sys.stdin = open("input.txt")
nodes,cnt = map(int,sys.stdin.readline().split())
arr = sorted(list(map(int,sys.stdin.readline().split())))
for i in set(permutations(arr,cnt)):
    print(*i)