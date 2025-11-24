EARTH = 15
SUN = 28
MOON = 19

e, s, m = map(int, input().split())
year = 1

while not (
    (year - e) % EARTH == 0 and (year - s) % SUN == 0 and (year - m) % MOON == 0
):
    year += 1

print(year)
