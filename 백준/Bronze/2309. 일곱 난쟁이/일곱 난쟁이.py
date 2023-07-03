import sys
#sys.stdin = open("input.txt", "r")
items = []
for i in range(9):
    items.append(int(input()))

from itertools import combinations
for i in (combinations(items, 7)):

    if(sum(i)== 100):
        for j in sorted(i):
            print(j)
        break
