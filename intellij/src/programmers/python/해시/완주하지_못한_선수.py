def solution(participant, completion):
    participant.sort()
    completion.sort()

    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]

    return participant[-1]


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
    participant_1 = ["leo", "kiki", "eden"]
    completion_1 = ["eden", "kiki"]
    answer_1 = "leo"
    result_1 = solution(participant_1, completion_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    participant_2 = ["marina", "josipa", "nikola", "vinko", "filipa"]
    completion_2 = ["josipa", "filipa", "marina", "nikola"]
    answer_2 = "vinko"
    result_2 = solution(participant_2, completion_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    participant_3 = ["mislav", "stanko", "mislav", "ana"]
    completion_3 = ["stanko", "ana", "mislav"]
    answer_3 = "mislav"
    result_3 = solution(participant_3, completion_3)
    print_result(3, result_3, answer_3)
