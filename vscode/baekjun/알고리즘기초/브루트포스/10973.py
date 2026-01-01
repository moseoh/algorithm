N = int(input())
arr = list(map(int, input().split()))

i = N - 2
while arr[i] < arr[i + 1]:
    i -= 1

if i < 0:
    print(-1)
else:
    j = N - 1
    while arr[j] > arr[i]:
        j -= 1

    arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1 :] = reversed(arr[i + 1 :])

    print(*arr)
