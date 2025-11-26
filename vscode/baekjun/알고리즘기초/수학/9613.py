import math
from itertools import combinations

t = int(input())


for _ in range(t):
    data = list(map(int, input().split()))
    nums = data[1:]

    print(sum(math.gcd(a, b) for a, b in combinations(nums, 2)))
