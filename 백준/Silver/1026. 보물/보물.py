a = input()
B = sorted(map(int,input().split()),reverse = True)
C = sorted(map(int,input().split()))
print(sum([i*j for i,j in zip(B,C)]))