def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False

    return True


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
    phone_book_1 = ["119", "97674223", "1195524421"]
    answer_1 = False
    result_1 = solution(phone_book_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    phone_book_2 = ["123","456","789"]
    answer_2 = True
    result_2 = solution(phone_book_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    phone_book_3 = ["12","123","1235","567","88"]
    answer_3 = False
    result_3 = solution(phone_book_3)
    print_result(3, result_3, answer_3)

    # 테스트 케이스 3
    phone_book_4 = ["11","211"]
    answer_4 = True
    result_4 = solution(phone_book_4)
    print_result(4, result_4, answer_4)