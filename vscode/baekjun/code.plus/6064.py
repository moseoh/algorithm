import math

for _ in range(int(input())):
    m, n, x, y = map(int, input().split())

    max_year = math.lcm(m, n)
    year = x

    while year <= max_year:
        if (year - 1) % n + 1 == y:
            break
        year += m

    if year > max_year:
        print(-1)
    else:
        print(year)
