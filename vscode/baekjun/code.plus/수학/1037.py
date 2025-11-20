n = int(input())
m = list(map(int, input().split())).sort()

print(m[0] * m[-1])
