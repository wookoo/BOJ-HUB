def solution(lottos, win_nums):
    answer = []
    win = {}

    zeros = 0
    success = 0
    fail = 0
    for num in lottos:
        if(num == 0):
            zeros += 1
            continue
        if(num in win_nums):
            success +=1
        else:
            fail +=1
            
    high = success + zeros
    row = 6 - (fail + zeros)
    k = {6:1,5:2,4:3,3:4,2:5,1:6,0:6}
    answer.append(k[high])
    answer.append(k[row])
    return answer