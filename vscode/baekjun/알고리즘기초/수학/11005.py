def change_num(num):
    if num < 10:
        return num
    else:
        return chr(num + 55)


N, B = map(int, input().split())

result = []
while N != 0:
    result.append(str(change_num(N % B)))
    N = N // B

print("".join(reversed(result)))
