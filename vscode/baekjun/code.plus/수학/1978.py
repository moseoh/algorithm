count = int(input())
n = list(map(int, input().split()))


def is_prime(num):
    if num < 2:
        return False
    if num == 2:
        return True
    if num % 2 == 0:
        return False

    for i in range(3, int(num**0.5) + 1, 2):
        if num % i == 0:
            return False
    return True


result = 0
for num in n:
    result += 1 if is_prime(num) else 0

print(result)
