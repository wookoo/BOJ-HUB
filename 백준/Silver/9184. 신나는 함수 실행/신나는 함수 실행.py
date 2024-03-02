import sys

dp = {}
def w(a,b,c):
    key = f"{a}-{b}-{c}"
    if key in dp:
        return dp[key]
    if(a<= 0 or b <= 0 or c <= 0):
        dp[key] = 1
        return 1
    if a > 20 or b > 20 or c > 20 :
        k = w(20,20,20)
        dp[key] = k
        return k
    if a < b and b < c :
        k =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        dp[key] = k
        return k

    k = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    dp[key] = k
    return k

#sys.stdin = open("input.txt")
a,b,c = 0,0,0
while True:
    a,b,c = map(int,sys.stdin.readline().split())
    if(a == -1 and b == -1 and c == -1):
        break
    print(f"w({a}, {b}, {c}) = {w(a,b,c)}")