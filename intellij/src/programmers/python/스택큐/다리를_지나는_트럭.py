from collections import deque

def solution(bridge_length, weight, truck_weights):
    current_time = 0
    current_weight = 0
    bridge = deque()

    for truck_weight in truck_weights:
        current_time += 1

        # 무게가 꽉찼다면 들어갈 수 있을때까지 내보내기
        while bridge and current_weight + truck_weight > weight:
            exit_time, exit_weight = bridge.popleft()
            current_weight -= exit_weight
            if current_time < exit_time:
                current_time = exit_time

        # 차량 진입
        bridge.append((current_time + bridge_length, truck_weight))
        current_weight += truck_weight

    return bridge[-1][0]


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
    bridge_length_1 = 100
    weight_1 = 100
    truck_weights_1 = [2,2]
    answer_1 = 102
    result_1 = solution(bridge_length_1, weight_1, truck_weights_1)
    print_result(1, result_1, answer_1)
    # bridge_length_1 = 2
    # weight_1 = 10
    # truck_weights_1 = [7, 4, 5, 6]
    # answer_1 = 8
    # result_1 = solution(bridge_length_1, weight_1, truck_weights_1)
    # print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    bridge_length_2 = 100
    weight_2 = 100
    truck_weights_2 = [10]
    answer_2 = 101
    result_2 = solution(bridge_length_2, weight_2, truck_weights_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    bridge_length_3 = 100
    weight_3 = 100
    truck_weights_3 = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
    answer_3 = 110
    result_3 = solution(bridge_length_3, weight_3, truck_weights_3)
    print_result(3, result_3, answer_3)
