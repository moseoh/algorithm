def solution(nums):
    n = len(nums) // 2
    kind = len(set(nums))

    return min(n, kind)


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
    nums_1 = [3,1,2,3]
    answer_1 = 2
    result_1 = solution(nums_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    nums_2 = [3,3,3,2,2,4]
    answer_2 = 3
    result_2 = solution(nums_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    nums_3 = [3,3,3,2,2,2]
    answer_3 = 2
    result_3 = solution(nums_3)
    print_result(3, result_3, answer_3)