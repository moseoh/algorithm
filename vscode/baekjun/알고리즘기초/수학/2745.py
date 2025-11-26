def get_num(char):
    if char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
        return ord(char) - 55
    else:
        return int(char)


N, B = input().split()
B = int(B)
result = 0

for i, char in enumerate(reversed(N)):
    result += get_num(char) * B**i

print(result)
