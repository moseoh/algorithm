from collections import deque

def solution(priorities, location):
    # 1. (우선순위, 인덱스) 튜플을 담은 데크(deque) 생성
    # 리스트 컴프리헨션으로 더 간결하게 작성 가능합니다.
    queue = deque([(p, i) for i, p in enumerate(priorities)])

    # 2. 정렬된 우선순위 리스트
    sorted_p = sorted(priorities, reverse=True)

    count = 0
    p_idx = 0  # sorted_p를 가리키는 포인터

    while queue:
        # pop(0) 대신 popleft() 사용 (O(1))
        task_p, task_idx = queue.popleft()

        # 현재 작업의 우선순위가 가장 높은 것보다 작으면 뒤로 보냄
        if task_p < sorted_p[p_idx]:
            queue.append((task_p, task_idx))
        else:
            # 현재 작업이 가장 높은 우선순위라면 인쇄(처리)
            count += 1
            p_idx += 1

            # 내가 찾는 인덱스인지 확인
            if task_idx == location:
                return count

    return count


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
    priorities_1 = [2, 1, 3, 2]
    location_1 = 2
    answer_1 = 1
    result_1 = solution(priorities_1, location_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    priorities_2 = [1, 1, 9, 1, 1, 1]
    location_2 = 0
    answer_2 = 5
    result_2 = solution(priorities_2, location_2)
    print_result(2, result_2, answer_2)
