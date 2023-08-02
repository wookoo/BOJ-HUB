j = [list(map(int,input().split())) for i in range(int(input()))]
for i in sorted(j,key = lambda x: (x[0],x[1])):
    print(f"{i[0]} {i[1]}")
