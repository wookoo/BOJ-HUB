target = int(input())
ans = 0
while(target > 1):
    if(target % 2 == 1):
        ans +=1
        target = (target -1)/2
    else:
        target = target/2

print(ans+1)