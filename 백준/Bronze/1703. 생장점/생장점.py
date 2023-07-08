import sys
while True:
    a = input()
    if a == "0":
        break
    a = list(map(int,a.split()))
    result  = 1
    size = a[0]
    arr = a[1:]
    leaf = [[arr[i*2],arr[i*2+1]] for i in range(size)]
    for mul,remove in leaf:
        result *= mul;
        result -= remove
    print(result)
    