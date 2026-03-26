import heapq


def solution(operations):
    max_heap = []
    min_heap = []

    for op in operations:
        (command, num) = op.split()
        if command == "I":
            heapq.heappush(max_heap, -int(num))
            heapq.heappush(min_heap, int(num))
        else:
            if not max_heap or not min_heap:
                continue

            if num == "1" and min_heap:
                min_heap.remove(-heapq.heappop(max_heap))
            elif num == "-1" and max_heap:
                max_heap.remove(-heapq.heappop(min_heap))

    max_value = -max_heap[0] if max_heap else 0
    min_value = min_heap[0] if min_heap else 0

    return [max_value, min_value]


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
    # # 테스트 케이스 1
    # operations = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
    # answer_1 = [0, 0]
    # result_1 = solution(operations)
    # print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    operations = ["D 1", "D 1", "I 1", "I -1", "I -2", "D 1"]
    answer_2 = [-1, -2]
    result_2 = solution(operations)
    print_result(2, result_2, answer_2)
