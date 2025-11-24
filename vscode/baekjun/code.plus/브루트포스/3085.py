size = int(input())
arr = []
result = 0
arr = [list(input()) for _ in range(size)]


def out_of_size(x, y):
    if x < 0 or x >= size:
        return True

    if y < 0 or y >= size:
        return True

    return False


def horizontal_max(y):
    global arr, size

    result = 1
    cnt = 1
    for i in range(size - 1):
        if arr[y][i] == arr[y][i + 1]:
            cnt += 1
            result = max(result, cnt)
        else:
            cnt = 1

    return result


def vertical_max(x):
    global arr, size

    result = 1
    cnt = 1
    for i in range(size - 1):
        if arr[i][x] == arr[i + 1][x]:
            cnt += 1
            result = max(result, cnt)
        else:
            cnt = 1

    return result


for i in range(size):
    for j in range(size - 1):
        # 세로 교환 horizontal
        arr[j][i], arr[j + 1][i] = arr[j + 1][i], arr[j][i]
        result = max(result, vertical_max(i))
        result = max(result, horizontal_max(j))
        if j + 1 < size:
            result = max(result, horizontal_max(j + 1))
        arr[j + 1][i], arr[j][i] = arr[j][i], arr[j + 1][i]

        # 가로 교환 vertical
        arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
        result = max(result, horizontal_max(i))
        result = max(result, vertical_max(j))
        if i + 1 < size:
            result = max(result, vertical_max(i + 1))
        arr[i][j + 1], arr[i][j] = arr[i][j], arr[i][j + 1]


print(result)
