import heapq

def solution(scoville, k):
    heapq.heapify(scoville)

    count = 0
    while len(scoville) > 1 and scoville[0] < k:
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)

        heapq.heappush(scoville, first + (second * 2))
        count += 1

    return count if scoville[0] >= k else -1


# def solution(scoville, k):
#     sorted_scoville = sorted(scoville)
#
#     count = 0
#     while len(sorted_scoville) > 1 and sorted_scoville[0] < k:
#         count += 1
#         sorted_scoville.insert(0, sorted_scoville.pop(0) + sorted_scoville.pop(0) * 2)
#         sorted_scoville.sort()
#
#     return count if sorted_scoville[0] >= k else -1


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
    scoville_1 = [1, 2, 3, 9, 10, 12]
    k_1 = 7
    answer_1 = 2
    result_1 = solution(scoville_1, k_1)
    print_result(1, result_1, answer_1)
