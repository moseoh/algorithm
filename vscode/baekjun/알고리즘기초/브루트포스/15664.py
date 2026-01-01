from itertools import combinations

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
comination = list(set(combinations(arr, M)))
comination.sort()

for com in comination:
    print(" ".join(str(c) for c in com))
