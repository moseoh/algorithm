def solution(numbers):
    str_numbers = sorted(map(str, numbers), key=lambda x: x * 3, reverse=True)

    answer = "".join(str_numbers)
    return '0' if answer[0] == '0' else answer


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
    numbers_1 = [6, 10, 2]
    answer_1 = "6210"
    result_1 = solution(numbers_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    numbers_2 = [0, 0, 0]
    answer_2 = "0"
    result_2 = solution(numbers_2)
    print_result(2, result_2, answer_2)
