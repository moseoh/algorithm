package src.programmers.고득점kit.그래프.순위;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] results1 = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer1 = 2;
        int result1 = new Solution().solution(n1, results1);
        PRINT_RESULT(1, result1, answer1);
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

    public int solution(int n, int[][] results) {
        Map<Integer, Score> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Score());
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            Score winnerScore = map.get(winner);
            Score loserScore = map.get(loser);
            
            winnerScore.wins.add(loser);
            winnerScore.wins.addAll(loserScore.loses);

            loserScore.loses.add(winner);
            loserScore.loses.addAll(winnerScore.loses);
        }

        int answer = 0;
        for (int i : map.keySet()) {
            if (map.get(i).total() == n - 1) answer++;
        }
        return answer;
    }

    class Score {
        public Set<Integer> wins;
        public Set<Integer> loses;

        public Score() {
            this.wins = new HashSet<>();
            this.loses = new HashSet<>();
        }

        public int total() {
            return wins.size() + loses.size();
        }
    }
}