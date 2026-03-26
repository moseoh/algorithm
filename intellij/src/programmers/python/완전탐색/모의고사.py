def solution(answers):
    a = [1, 2, 3, 4, 5]  # 5
    b = [2, 1, 2, 3, 2, 4, 2, 5]  # 8
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]  # 10
    a_count = 0
    b_count = 0
    c_count = 0

    for i in range(len(answers)):
        if answers[i] == a[i % 5]:
            a_count += 1
        if answers[i] == b[i % 8]:
            b_count += 1
        if answers[i] == c[i % 10]:
            c_count += 1

    max_count = max(a_count, b_count, c_count)
    answer = []
    if max_count == a_count:
        answer.append(1)
    if max_count == b_count:
        answer.append(2)
    if max_count == c_count:
        answer.append(3)

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
    # answers_1 = [1, 2, 3, 4, 5]
    # answer_1 = [1]
    # result_1 = solution(answers_1)
    # print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    answers_2 = [1, 3, 2, 4, 2]
    answer_2 = [1, 2, 3]
    result_2 = solution(answers_2)
    print_result(2, result_2, answer_2)
