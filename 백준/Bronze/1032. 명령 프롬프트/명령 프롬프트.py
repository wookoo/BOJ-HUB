j = [input() for i in range(int(input()))]
for index in range(len(j[0])):
    temp = [line[index] for line in j]
    if(len(set(temp))) == 1:
        
        print(temp[0],end="")
    else:
        print("?",end="")
    
