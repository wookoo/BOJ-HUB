import sys
#sys.stdin = open("input.txt")
dp = [ 0 for i in range(102)]
dp[1] = dp[2] = dp[3] = 1
dp[4] = dp[5] = 2
for i in range(6,102):
    dp[i] = dp[i-1] + dp[i-5]

depth = int(sys.stdin.readline())
for i in range(depth):
    line = int(sys.stdin.readline())
    print(dp[line])