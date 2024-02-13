import sys
#sys.stdin = open("input.txt")
pokemon, out = map(int, sys.stdin.readline().split())
index = {}
name = {}
for i in range(1, 1+pokemon):
    namein = sys.stdin.readline().strip()
    name[namein] = i
    name[str(i)] = namein

for i in range(out):
    k = sys.stdin.readline().strip()
    print(name[k])
