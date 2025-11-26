A, B = map(int, input().split())
m = int(input())
nums = list(map(int, input().split()))

num = 0
for v in nums:
    num = num * A + v

result = []
while num != 0:
    result.append(num % B)
    num //= B

print(*result[::-1])
