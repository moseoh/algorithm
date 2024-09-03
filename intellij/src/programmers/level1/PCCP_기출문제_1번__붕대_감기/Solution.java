package src.programmers.level1.PCCP_기출문제_1번__붕대_감기;

class Solution {
    public static void main(String[] args) {
        int[] bandage1 = new int[]{5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int answer1 = 5;
        int result1 = new Solution().solution(bandage1, health1, attacks1);
        PRINT_RESULT(1, result1, answer1);

        int[] bandage2 = new int[]{3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = new int[][]{{1, 15}, {5, 16}, {8, 6}};
        int answer2 = -1;
        int result2 = new Solution().solution(bandage2, health2, attacks2);
        PRINT_RESULT(2, result2, answer2);

        int[] bandage3 = new int[]{4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = new int[][]{{1, 15}, {5, 16}, {8, 6}};
        int answer3 = -1;
        int result3 = new Solution().solution(bandage3, health3, attacks3);
        PRINT_RESULT(3, result3, answer3);

        int[] bandage4 = new int[]{1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = new int[][]{{1, 2}, {3, 2}};
        int answer4 = 3;
        int result4 = new Solution().solution(bandage4, health4, attacks4);
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

    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int prevTime = 0;

        for (int[] attack : attacks) {
            int time = attack[0] - prevTime - 1;
            prevTime = attack[0];

            // 매초 회복
            currentHealth += time * bandage[1];
            // 추가 회복
            currentHealth += (time / bandage[0]) * bandage[2];
            // 최대 체력을 넘지 않음
            currentHealth = Math.min(health, currentHealth);
            // 공격을 당한다.
            currentHealth -= attack[1];

            // 사망했다면 -1 리턴
            if (currentHealth <= 0) {
                return -1;
            }
        }

        return currentHealth;
    }
}