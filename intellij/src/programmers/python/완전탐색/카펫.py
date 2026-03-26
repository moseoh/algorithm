from itertools import permutations


def solution(brown, yellow):
    area = brown + yellow
    for m in range(1, area + 1):
        if area % m != 0:
            continue

        n = area // m
        if (m - 1 + n - 1) * 2 == brown and (m - 2) * (n - 2) == yellow:
            return [max(m, n), min(m, n)]

    return []


def print_result(index, result, answer):
    template = f"""테스트 케이스 {index}: {"정답" if result == answer else "오답"}
    - 실행 결과: {result}
    - 기댓값: {answer}
"""

    if result == answer:
        print(template)
    else:
        raise SystemExit(template)


if __name__ == "__main__":
    # 테스트 케이스 1
    brown_1 = 10
    yellow_1 = 2
    answer_1 = [4, 3]
    result_1 = solution(brown_1, yellow_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    brown_2 = 24
    yellow_2 = 24
    answer_2 = [8, 6]
    result_2 = solution(brown_2, yellow_2)
    print_result(2, result_2, answer_2)

# (m-1 + n-1) * 2 = brown. 2m + 2n - 4 = brown
# (m-2) * (n-2) = yellow. mn - 2m - 2n + 4 = yellow
#
