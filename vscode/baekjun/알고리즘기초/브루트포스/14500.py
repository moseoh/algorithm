N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
tetrominos = [
    [(0, 0), (0, 1), (1, 0), (1, 1)],  # ㅁ
    [(0, 0), (0, 1), (0, 2), (0, 3)],  # ㅡ
    [(0, 0), (1, 0), (2, 0), (3, 0)],  # ㅣ
    [(0, 0), (0, 1), (0, 2), (1, 0)],  # ㄴ
    [(1, 0), (1, 1), (1, 2), (0, 2)],  # ㄱ
    [(0, 0), (1, 0), (1, 1), (1, 2)],  # ㄴ
    [(0, 0), (0, 1), (0, 2), (1, 2)],  # ㄱ
    [(0, 0), (1, 0), (2, 0), (2, 1)],  # ㄴ
    [(2, 0), (2, 1), (1, 1), (0, 1)],  # ㄴ
    [(0, 0), (0, 1), (1, 0), (2, 0)],  # ㄴ
    [(0, 0), (0, 1), (1, 1), (2, 1)],  # ㄴ
    [(0, 0), (0, 1), (0, 2), (1, 1)],  # ㅜ
    [(1, 0), (1, 1), (1, 2), (0, 1)],  # ㅗ
    [(0, 0), (1, 0), (2, 0), (1, 1)],  # ㅏ
    [(1, 0), (0, 1), (1, 1), (2, 1)],  # ㅓ
    [(1, 0), (2, 0), (0, 1), (1, 1)],  # ㄹ
    [(0, 0), (1, 0), (1, 1), (2, 1)],  # ㄹ
    [(1, 0), (0, 1), (1, 1), (0, 2)],  # ㄹ
    [(0, 0), (0, 1), (1, 1), (1, 2)],  # ㄹ
]


def find(arr, i, j, N, M, tetromino):
    result = 0

    for t in tetromino:
        nextI = i + t[0]
        nextJ = j + t[1]

        if nextI < 0 or nextI >= N or nextJ < 0 or nextJ >= M:
            return 0

        result += arr[nextI][nextJ]

    return result


result = 0

for i in range(N):
    for j in range(M):
        for tetromino in tetrominos:
            result = max(result, find(arr, i, j, N, M, tetromino))

print(result)
