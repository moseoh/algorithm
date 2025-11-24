n = int(input())
list = list(map(int, input().split()))

result = [-1] * n
stack = []

for i in range(n):
    while stack and list[i] > list[stack[-1]]:
        result[stack.pop()] = list[i]

    stack.append(i)

print(" ".join(map(str, result)))
