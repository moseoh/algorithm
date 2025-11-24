num = int(input())
len = len(str(num)) - 1
result = 0

for i in range(len):
    result += 9 * (10**i) * (i + 1)
result += (num - 10**len + 1) * (len + 1)
print(result)
