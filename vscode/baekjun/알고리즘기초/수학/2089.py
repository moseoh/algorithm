num = int(input())

quotient = num
result = []

if num == 0:
    print(0)

else:
    while quotient != 0:
        remainder = quotient % -2
        quotient = quotient // -2

        if remainder == -1:
            remainder = 1
            quotient += 1

        result.append(remainder)

    print("".join(map(str, reversed(result))))
