import sys


def solve(num):
    prev = 1 % num
    len = 1

    while prev != 0:
        prev = (prev * 10 + 1) % num
        len += 1

    return len


for line in sys.stdin:
    n = int(line.strip())
    print(solve(n))
