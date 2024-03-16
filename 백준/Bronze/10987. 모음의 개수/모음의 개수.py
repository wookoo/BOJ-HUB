import sys
#sys.stdin = open("input.txt")
a = sys.stdin.readline().strip()
ans = 0
for i in a:
    if i in ["a", 'e', 'i', 'o', "u"]:
        ans += 1

print(ans)