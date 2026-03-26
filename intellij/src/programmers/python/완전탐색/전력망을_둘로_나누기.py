from collections import defaultdict

def solution(n, wires):
    # 1. 그래프 구성
    graph = defaultdict(list)
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)

    # 2. DFS로 서브트리 크기 계산
    subtree_size = [0] * (n + 1)
    visited = [False] * (n + 1)

    def dfs(nod_e):
        visited[nod_e] = True
        size = 1
        for neighbor in graph[nod_e]:
            if not visited[neighbor]:
                size += dfs(neighbor)
        subtree_size[nod_e] = size
        return size

    dfs(1)

    # 3. 최소 차이 계산
    min_diff = n  # 최대 가능한 차이
    for node in range(2, n + 1):
        diff = abs(2 * subtree_size[node] - n)
        min_diff = min(min_diff, diff)

    return min_diff


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
    n_1 = 9
    wires_1 = [[1, 3], [2, 3], [3, 4], [4, 5], [4, 6], [4, 7], [7, 8], [7, 9]]
    answer_1 = 3
    result_1 = solution(n_1, wires_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 2
    n_2 = 4
    wires_2 = [[1, 2], [2, 3], [3, 4]]
    answer_2 = 0
    result_2 = solution(n_2, wires_2)
    print_result(2, result_2, answer_2)

    # 테스트 케이스 3
    n_3 = 7
    wires_3 = [[1, 2], [2, 7], [3, 7], [3, 4], [4, 5], [6, 7]]
    answer_3 = 1
    result_3 = solution(n_3, wires_3)
    print_result(3, result_3, answer_3)
