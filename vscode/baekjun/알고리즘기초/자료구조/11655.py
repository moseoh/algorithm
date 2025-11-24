result = []
for char in input():
    if char.islower():
        temp = ord(char) + 13
        if temp > 122:
            temp -= 26
        result.append(chr(temp))
    elif char.isupper():
        temp = ord(char) + 13
        if temp > 90:
            temp -= 26
        result.append(chr(temp))
    else:
        result.append(char)

print("".join(result))
