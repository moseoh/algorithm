from collections import defaultdict



def solution(clothes):
    mappings = defaultdict(list)
    for name, category in clothes:
        mappings[category].append(name)

    answer = 1
    for k, v in mappings.items():
        answer *= (len(v) + 1)
    return answer - 1


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
    phone_book_1 = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
    answer_1 = 5
    result_1 = solution(phone_book_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    phone_book_2 = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
    answer_2 = 3
    result_2 = solution(phone_book_2)
    print_result(2, result_2, answer_2)
