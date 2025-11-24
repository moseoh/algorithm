n = int(input())
list = list(map(int, input().split()))
stack = []
result = [-1] * n
max_num = 0
for num in list:
    max_num = max(max_num, num)

cnt_list = [0] * (max_num + 1)
for num in list:
    cnt_list[num] += 1

for i in range(n):
    while stack and cnt_list[list[stack[-1]]] < cnt_list[list[i]]:
        idx = stack.pop()
        result[idx] = list[i]

    stack.append(i)

print(" ".join(map(str, result)))
