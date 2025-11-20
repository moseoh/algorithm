"""
O(N√N) 시간 복잡도로 느리다.

n = int(input())
result = 0


def f(num):
    result = 0
    for i in range(1, int(num**0.5) + 1):
        if num % i == 0:
            result += i
            if num / i != i:
                result += num // i
    return result


for num in range(1, n + 1):
    result += f(num)

print(result)
"""

# O(N)
n = int(input())
result = 0

for num in range(1, n + 1):
    result += (n // num) * num

print(result)
