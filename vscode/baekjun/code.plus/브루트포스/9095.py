num_list = [1, 2, 3]
result = 0


def check(input, sum):
    global result

    if sum > input:
        return
    if sum == input:
        result += 1
        return

    for num in num_list:
        check(input, sum + num)


for _ in range(int(input())):
    result = 0
    check(int(input()), 0)
    print(result)
