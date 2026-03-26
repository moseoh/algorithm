def solution(array, commands):
    answer = []
    for command in commands:
        answer.append(sorted(array[command[0] - 1 : command[1]])[command[2] - 1])

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
    array_1 = [1, 5, 2, 6, 3, 7, 4]
    commands_1 = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
    answer_1 = [5, 6, 3]
    result_1 = solution(array_1, commands_1)
    print_result(1, result_1, answer_1)
