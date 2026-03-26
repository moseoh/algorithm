from collections import Counter

def solution(progresses, speeds):
    days = []
    curr_max = 0

    for p, s in zip(progresses, speeds):
        # 1. 올림 계산 (p-100을 s로 나눈 뒤 부호 반전)
        day = -((p - 100) // s)

        # 2. 이전 작업 중 가장 오래 걸리는 날짜와 비교
        curr_max = max(curr_max, day)
        days.append(curr_max)

    # 3. 앞에서 질문하신 Counter를 활용해 마무리
    from collections import Counter
    return list(Counter(days).values())


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
    progresses_1 = [93, 30, 55]
    speeds_1 = [1, 30, 5]
    answer_1 = [2, 1]
    result_1 = solution(progresses_1, speeds_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    progresses_2 = [95, 90, 99, 99, 80, 99]
    speeds_2 = [1, 1, 1, 1, 1, 1]
    answer_2 = [1, 3, 2]
    result_2 = solution(progresses_2, speeds_2)
    print_result(2, result_2, answer_2)
