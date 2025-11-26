N = int(input())

max = N


result = []
num = 2
while N >= num * num:
    while N % num == 0:
        print(num)
        N //= num

    num += 1

if N != 1:
    print(N)
