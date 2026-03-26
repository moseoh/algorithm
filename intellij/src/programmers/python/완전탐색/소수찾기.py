from itertools import permutations


def solution(numbers):
    # Step 1: 가능한 모든 숫자 조합 생성
    candidates = set()

    for length in range(1, len(numbers) + 1):
        for perm in permutations(numbers, length):
            # 문자열 조합 → 정수 변환 (앞자리 0 자동 제거)
            num = int(''.join(perm))
            candidates.add(num)

    # Step 2: 소수 판별 함수
    def is_prime(n):
        if n < 2:
            return False
        if n == 2:
            return True
        if n % 2 == 0:
            return False
        for i in range(3, int(n ** 0.5) + 1, 2):
            if n % i == 0:
                return False
        return True

    # Step 3: 소수 개수 카운트
    return sum(1 for num in candidates if is_prime(num))


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
    numbers_1 = "17"
    answer_1 = 3
    result_1 = solution(numbers_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    numbers_2 = "011"
    answer_2 = 2
    result_2 = solution(numbers_2)
    print_result(2, result_2, answer_2)
