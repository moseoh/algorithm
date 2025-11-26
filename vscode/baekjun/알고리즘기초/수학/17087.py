from functools import reduce
from math import gcd

n, s = map(int, input().split())
arr = list(map(int, input().split()))

distances = [abs(a - s) for a in arr]

result = reduce(gcd, distances)

print(result)
