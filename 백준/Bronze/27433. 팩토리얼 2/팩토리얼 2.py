def factorial(n):
    if n == 1:
        return 1
    if n == 0:
        return 1
    return n*factorial(n-1)

import sys
num = int(sys.stdin.readline())
print(factorial(num))