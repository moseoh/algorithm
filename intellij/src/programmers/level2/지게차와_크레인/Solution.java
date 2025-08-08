package src.programmers.level2.지게차와_크레인;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String[] storage1 = new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests1 = new String[]{"A", "BB", "A"};
        int answer1 = 11;
        int result1 = new Solution().solution(storage1, requests1);
        PRINT_RESULT(1, result1, answer1);

        String[] storage2 = new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] requests2 = new String[]{"C", "B", "B", "B", "B", "H"};
        int answer2 = 4;
        int result2 = new Solution().solution(storage2, requests2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) {
            System.out.println(sb);
        } else {
            throw new RuntimeException(sb.toString());
        }
    }

    static final char  REMOVED = '0';
    static final char  REMOVED_AND_BLOCK = '1';
    final        int[] dx      = new int[]{0, 0, 1, -1};
    final        int[] dy      = new int[]{1, -1, 0, 0};
    int xMax;
    int yMax;

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        char[][] grid = new char[n][m];

        // 초기 그리드 설정
        for (int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }

        // 각 요청 처리
        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 1) {
                // 지게차: 접근 가능한 것만 제거
                boolean[][] accessible = findAccessible(grid, n, m);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target && accessible[i][j]) {
                            grid[i][j] = '.'; // 제거 표시
                        }
                    }
                }
            } else {
                // 크레인: 모든 해당 컨테이너 제거
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target) {
                            grid[i][j] = '.'; // 제거 표시
                        }
                    }
                }
            }
        }

        // 남은 컨테이너 개수 세기
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 창고 외부에서 접근 가능한 컨테이너들을 찾는 메서드
     * BFS를 사용하여 경계에서부터 도달 가능한 모든 컨테이너를 표시
     */
    private boolean[][] findAccessible(char[][] grid, int n, int m) {
        boolean[][] accessible = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};  // 상하좌우
        int[] dy = {0, 0, -1, 1};

        // 1단계: 경계의 모든 칸을 시작점으로 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    if (grid[i][j] == '.') {
                        // 경계의 제거된 칸은 BFS 시작점
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    } else {
                        // 경계의 컨테이너는 바로 접근 가능
                        accessible[i][j] = true;
                    }
                }
            }
        }

        // 2단계: BFS로 내부의 접근 가능한 컨테이너들 찾기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 체크 및 방문 체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (grid[nx][ny] == '.') {
                        // 제거된 칸은 통과 가능하므로 계속 탐색
                        queue.add(new int[]{nx, ny});
                    } else {
                        // 컨테이너가 있는 칸은 접근 가능으로 표시
                        // 하지만 더 이상 통과할 수 없으므로 큐에 추가하지 않음
                        accessible[nx][ny] = true;
                    }
                }
            }
        }

        return accessible;
    }
}