def solution(citations):
    citations.sort(reverse=True)

    for i, v in enumerate(citations):
        if v < i + 1:
            return i

    return len(citations)


def print_result(index, result, answer):
    template = f"""테스트 케이스 {index}: {"정답" if result == answer else "오답"}
    - 실행 결과: {result}
    - 기댓값: {answer}
"""

    if result == answer:
        print(template)
    else:
        raise SystemExit(template)


# 0 1 3 5 6
if __name__ == "__main__":
    # 테스트 케이스 1
    # citations_1 = [0, 0, 0]
    # answer_1 = 3
    # result_1 = solution(citations_1)
    # print_result(1, result_1, answer_1)

    citations_1 = [10, 10, 10]
    answer_1 = 3
    result_1 = solution(citations_1)
    print_result(1, result_1, answer_1)
