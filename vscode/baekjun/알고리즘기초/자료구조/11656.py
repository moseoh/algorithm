str = input()
results = []

length = len(str)
for i in range(length):
    results.append(str[i:length])

results.sort()
for result in results:
    print(result)
