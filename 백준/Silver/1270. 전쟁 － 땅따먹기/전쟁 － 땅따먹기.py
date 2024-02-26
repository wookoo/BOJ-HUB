import sys
#sys.stdin = open("input.txt")
size = int(sys.stdin.readline())
for _ in range(size):
    people,*item = map(int,sys.stdin.readline().split())
    ans = {}
    for i in item:
        if not i in ans:
            ans[i] = 0
        ans[i] += 1

    result = sorted(ans.items(), key= lambda x : x[1],reverse=True)

    if result[0][1] > people/2:
        print(result[0][0])
    else :
        print("SYJKGW")
