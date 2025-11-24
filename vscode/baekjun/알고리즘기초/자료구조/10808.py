list = [0] * 26

for char in input():
    list[ord(char) - 97] += 1

print(" ".join(map(str, list)))
