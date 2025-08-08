package src.programmers.level2.완전범죄;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] info1 = new int[][]{{1, 2}, {2, 3}, {2, 1}};
        int n1 = 4;
        int m1 = 4;
        int answer1 = 2;
        int result1 = new Solution().solution(info1, n1, m1);
        PRINT_RESULT(1, result1, answer1);

        int[][] info2 = new int[][]{{1, 2}, {2, 3}, {2, 1}};
        int n2 = 1;
        int m2 = 7;
        int answer2 = 0;
        int result2 = new Solution().solution(info2, n2, m2);
        PRINT_RESULT(2, result2, answer2);

        int[][] info3 = new int[][]{{3, 3}, {3, 3}};
        int n3 = 7;
        int m3 = 1;
        int answer3 = 6;
        int result3 = new Solution().solution(info3, n3, m3);
        PRINT_RESULT(3, result3, answer3);

        int[][] info4 = new int[][]{{3, 3}, {3, 3}};
        int n4 = 6;
        int m4 = 1;
        int answer4 = -1;
        int result4 = new Solution().solution(info4, n4, m4);
        PRINT_RESULT(4, result4, answer4);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;

        // dp[i][a] = i번째 물건까지 고려했을 때, A의 흔적이 a개일 때 B의 흔적의 최솟값
        int[][] dp = new int[itemCount + 1][n];
        for (int i = 0; i <= itemCount; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for (int i = 0; i < itemCount; i++) {
            for (int a = 0; a < n; a++) {
                // 현재 상태가 도달 불가능하면 건너뛰기
                if (dp[i][a] == Integer.MAX_VALUE) {
                    continue;
                }

                // 경우 1: A도둑이 i번째 물건을 훔치는 경우
                int newTraceA = a + info[i][0];
                if (newTraceA < n) { // A도둑이 붙잡히지 않는 조건
                    dp[i + 1][newTraceA] = Math.min(dp[i + 1][newTraceA], dp[i][a]);
                }

                // 경우 2: B도둑이 i번째 물건을 훔치는 경우
                int newTraceB = dp[i][a] + info[i][1];
                if (newTraceB < m) { // B도둑이 붙잡히지 않는 조건
                    dp[i + 1][a] = Math.min(dp[i + 1][a], newTraceB);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        // 결과 찾기: 가능한 A의 흔적 중 최솟값
        for (int a = 0; a < n; a++) {
            if (dp[itemCount][a] < m) {
                return a;
            }
        }

        // 어떤 방법으로도 불가능한 경우
        return -1;
    }

}