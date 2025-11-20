import sys


def seive(num):
    prime = [True] * (num + 1)
    prime[0] = prime[1] = False
    for i in range(2, int(num**0.5) + 1):
        if prime[i]:
            for j in range(i * i, num + 1, i):
                prime[j] = False
    return prime


prime = seive(1000000)

# 소수만 따로 저장
prime_list = []
for i in range(3, 1000001, 2):
    if prime[i]:
        prime_list.append(i)

for line in sys.stdin:
    n = int(line.strip())
    if n == 0:
        break

    check = False
    for i in prime_list:  # 소수만 검사!
        if prime[n - i]:
            print(f"{n} = {i} + {n - i}")
            check = True
            break

    if not check:
        print("Goldbach's conjecture is wrong.")
