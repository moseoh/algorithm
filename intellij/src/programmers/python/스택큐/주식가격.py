def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []  # 가격이 떨어지지 않은 시점의 인덱스를 보관

    for i, price in enumerate(prices):
        # 1. 가격이 떨어졌다면? (현재 가격 < 스택 최상단 인덱스의 가격)
        while stack and price < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j  # 버틴 시간 계산

        # 2. 현재 인덱스 추가
        stack.append(i)

    # 3. 끝까지 가격이 떨어지지 않은 나머지 인덱스들 처리
    while stack:
        j = stack.pop()
        answer[j] = n - 1 - j

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
    prices_1 = [1, 2, 3, 2, 3]
    answer_1 = [4, 3, 1, 1, 0]
    result_1 = solution(prices_1)
    print_result(1, result_1, answer_1)
