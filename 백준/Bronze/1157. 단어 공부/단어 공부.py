a = input().upper()
data = dict()
for i in a:
    if not i in data:
        data[i] = 0
    data[i] +=1 

result = sorted(list(zip(data.keys(),data.values())),key= lambda x:x[1],reverse=True)
try:
    if(result[0][1] == result[1][1]):
        print("?")
    else:
        print(result[0][0])
except:
    print(result[0][0])