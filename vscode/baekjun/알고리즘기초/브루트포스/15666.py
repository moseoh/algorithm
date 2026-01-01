N, M = map(int, input().split())
nums = sorted(set(map(int, input().split())))


def backtracking(arr: list):
    if len(arr) == M:
        print(*arr)
        return

    for num in nums:
        if len(arr) > 0 and arr[-1] > num:
            continue
        arr.append(num)
        backtracking(arr)
        arr.pop()


backtracking([])
