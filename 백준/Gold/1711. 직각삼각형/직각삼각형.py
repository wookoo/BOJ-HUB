import sys
size = int(sys.stdin.readline())
px_list = []
py_list = []
for _ in range(size):
    x, y = map(int, sys.stdin.readline().split())
    px_list.append(x)
    py_list.append(y)
ans = 0
for a in range(size - 2):
    for b in range(a + 1, size - 1):
        for c in range(b + 1, size):
            ax, ay = px_list[a], py_list[a]
            bx, by = px_list[b], py_list[b]
            cx, cy = px_list[c], py_list[c]
            a_to_b = (ax - bx) ** 2 + (ay - by) ** 2
            a_to_c = (ax - cx) ** 2 + (ay - cy) ** 2
            b_to_c = (bx - cx) ** 2 + (by - cy) ** 2
            if a_to_b + a_to_c == b_to_c or a_to_c + b_to_c == a_to_b or a_to_b + b_to_c == a_to_c:
                ans += 1
print(ans)