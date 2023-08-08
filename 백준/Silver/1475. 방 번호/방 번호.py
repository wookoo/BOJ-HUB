a = input()
j = [0] * 10
for i in a:
    index = int(i)
    if(index == 6 or index == 9):
        if(j[6] <= j[9]):
            j[6] +=1
        else:
            j[9] +=1
    else:
        j[index] += 1

print(max(j))