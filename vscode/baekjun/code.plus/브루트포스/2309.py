list = []

MAX = 9

sum = 0
for _ in range(MAX):
    n = int(input())
    if n == 0:
        break
    list.append(n)
    sum += n

list.sort()

a, b = 0, 0
for i in range(MAX + 1):
    for j in range(i + 1, MAX):
        if sum - (list[i] + list[j]) == 100:
            a, b = i, j

for i, v in enumerate(list):
    if i != a and i != b:
        print(v)
