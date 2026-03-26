def solution(sizes):
    max_x = 0
    max_y = 0

    for size in sizes:
        max_x = max(max_x, max(size))
        max_y = max(max_y, min(size))

    return max_x * max_y


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
    sizes_1 = [[60, 50], [30, 70], [60, 30], [80, 40]]
    answer_1 = 4000
    result_1 = solution(sizes_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    sizes_2 = [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]
    answer_2 = 120
    result_2 = solution(sizes_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    sizes_3 = [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
    answer_3 = 133
    result_3 = solution(sizes_3)
    print_result(3, result_3, answer_3)
