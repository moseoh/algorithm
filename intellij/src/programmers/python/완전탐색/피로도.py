def solution(k, dungeons):
    n = len(dungeons)
    visited = [False] * n
    max_count = 0

    def dfs(cost, count):
        nonlocal max_count
        max_count = max(max_count, count)

        if count == n:
            return

        for i in range(n):
            min_req, current_cost = dungeons[i]

            if not visited[i] and cost >= min_req:
                visited[i] = True
                dfs(cost - current_cost, count + 1)
                visited[i] = False

    dfs(k, 0)

    return max_count


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
    k_1 = 80
    dungeons_1 = [[80, 20], [50, 40], [30, 10]]
    answer_1 = 3
    result_1 = solution(k_1, dungeons_1)
    print_result(1, result_1, answer_1)
