class Node:
    def __init__(self,root=None):
        self.root = root
        self.money = 0
        
    def __repr__(self):
        return str(self.money)
    
def solution(enroll, referral, seller, amount):
    people = {}

    
    people["-"] = Node()
    for name,root in zip(enroll,referral):
        if name in people:
            continue
        people[name] = Node(people[root])

    
    
    for name,money in zip(seller,amount):
        money = money *100
        #print(name,money)
        now = people[name]
        while now != None and money > 0:
            
            now.money += money - money//10
            money //= 10
            
            now = now.root
        
    #print(people)
    answer = []
    for name in enroll:
        answer.append(people[name].money)
    
    return answer