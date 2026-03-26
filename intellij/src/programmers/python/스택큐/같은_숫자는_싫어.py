def solution(arr):
    answer = []

    for i in arr:
        if answer and answer[-1] == i:
            continue
        answer.append(i)

    return answer


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
    phone_book_1 = [1, 1, 3, 3, 0, 1, 1]
    answer_1 = [1, 3, 0, 1]
    result_1 = solution(phone_book_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    phone_book_2 = [4, 4, 4, 3, 3]
    answer_2 = [4, 3]
    result_2 = solution(phone_book_2)
    print_result(2, result_2, answer_2)
