import heapq

def solution(jobs):
    # 1. 요청 시간(jobs[i][0])을 기준으로 먼저 정렬 (O(N log N))
    # 원본 인덱스를 정렬 기준으로 활용하려면 enumerate를 포함시킵니다.
    jobs_list = sorted([(req, proc, i) for i, (req, proc) in enumerate(jobs)])

    n = len(jobs)
    current_time, done_count, job_idx = 0, 0, 0
    total_duration = 0
    heap = [] # (소요시간, 요청시간, 인덱스) 순으로 담을 힙

    while done_count < n:
        # 2. 현재 시간까지 들어온 모든 작업을 힙에 투입
        while job_idx < n and jobs_list[job_idx][0] <= current_time:
            req, proc, idx = jobs_list[job_idx]
            # 힙의 정렬 기준: 1순위 소요시간(proc), 2순위 요청시간(req), 3순위 인덱스(idx)
            heapq.heappush(heap, (proc, req, idx))
            job_idx += 1

        if heap:
            # 3. 처리 가능한 작업 중 소요시간이 가장 짧은 것을 꺼냄 (SJF)
            proc, req, idx = heapq.heappop(heap)
            current_time += proc
            total_duration += (current_time - req) # 종료 시간 - 요청 시간
            done_count += 1
        else:
            # 4. 처리할 작업이 없으면 다음 작업이 들어오는 시간으로 점프 (Idle Time 해결)
            current_time = jobs_list[job_idx][0]

    return total_duration // n

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
    jobs_1 = [[0, 3], [1, 9], [3, 5]]
    answer_1 = 8
    result_1 = solution(jobs_1)
    print_result(1, result_1, answer_1)
