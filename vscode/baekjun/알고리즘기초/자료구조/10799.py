input = input()
result = 0
stack = 0

for i in range(len(input)):
    if input[i] == "(":
        if input[i + 1] != ")":
            stack += 1
    else:
        if input[i - 1] == "(":
            result += stack
        else:
            result += 1
            stack -= 1

print(result)
