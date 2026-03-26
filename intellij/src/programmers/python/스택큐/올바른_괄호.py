def solution(s) -> bool:
    stack = []
    for ch in s.strip():
        if ch == '(':
            stack.append(ch)
        else:
            if not stack:
                return False
            elif stack[-1] == ')':
                return False
            else:
                stack.pop()

    return len(stack) == 0


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
    s_1 = "()()"
    answer_1 = True
    result_1 = solution(s_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    s_2 = "(())()"
    answer_2 = True
    result_2 = solution(s_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    s_3 = ")()("
    answer_3 = False
    result_3 = solution(s_3)
    print_result(3, result_3, answer_3)

    # 테스트 케이스 4
    s_4 = "(()("
    answer_4 = False
    result_4 = solution(s_4)
    print_result(4, result_4, answer_4)
