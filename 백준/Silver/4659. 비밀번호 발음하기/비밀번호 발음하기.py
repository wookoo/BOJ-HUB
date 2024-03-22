# 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
# 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
# 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다

import re
import sys

def ans(string,flag):
    temp = "not acceptable."
    if flag:
        temp = "acceptable."
    print(f"<{string}> is {temp}")
#sys.stdin = open("input.txt")
pattern1 = "[aeiou]{1,}"
pattern2 = "([aeiou]{3,})|([^aeiou]{3,})"
pattern3 = "([a-df-np-z])\\1"
string = ""
while True:
    string = sys.stdin.readline().strip()
    if string == "end":
        break
    ans(string,re.search(pattern1,string) and not re.search(pattern2,string) and not re.search(pattern3,string))

