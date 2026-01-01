from itertools import product

N, M = map(int, input().split())
unique_nums = sorted(set(map(int, input().split())))

for per in product(unique_nums, repeat=M):
    print(*per)
