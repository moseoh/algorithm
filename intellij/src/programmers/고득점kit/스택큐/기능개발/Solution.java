package src.programmers.고득점kit.스택큐.기능개발;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        int[] progresses1 = new int[]{93, 30, 55};
//        int[] speeds1 = new int[]{1, 30, 5};
//        int[] answer1 = new int[]{2, 1};
//        int[] result1 = new Solution().solution(progresses1, speeds1);
//        PRINT_RESULT(1, result1, answer1);
//
//        int[] progresses2 = new int[]{95, 90, 99, 99, 80, 99};
//        int[] speeds2 = new int[]{1, 1, 1, 1, 1, 1};
//        int[] answer2 = new int[]{1, 3, 2};
//        int[] result2 = new Solution().solution(progresses2, speeds2);
//        PRINT_RESULT(2, result2, answer2);
//
//        int[] progresses3 = new int[]{5, 80, 80, 70};
//        int[] speeds3 = new int[]{5, 25, 25, 10}; // 19, 1, 1, 3
//        int[] answer3 = new int[]{4};
//        int[] result3 = new Solution().solution(progresses3, speeds3);
//        PRINT_RESULT(3, result3, answer3);

        int[] progresses4 = new int[]{};
        int[] speeds4 = new int[]{};
        int[] answer4 = new int[]{0};
        int[] result4 = new Solution().solution(progresses4, speeds4);
        PRINT_RESULT(4, result4, answer4);

        int[] progresses5 = new int[]{99, 93, 30}; //
        int[] speeds5 = new int[]{1, 6, 30};
        int[] answer5 = new int[]{1, 1, 1};
        int[] result5 = new Solution().solution(progresses5, speeds5);
        PRINT_RESULT(5, result5, answer5);

        int[] progresses6 = new int[]{50, 95, 96, 80, 80, 70};
        int[] speeds6 = new int[]{10, 6, 6, 1, 1, 1};
        int[] answer6 = new int[]{3, 2, 1};
        int[] result6 = new Solution().solution(progresses6, speeds6);
        PRINT_RESULT(6, result6, answer6);

        int[] progresses7 = new int[]{99, 99, 99, 99, 99};
        int[] speeds7 = new int[]{99, 99, 99, 99, 99};
        int[] answer7 = new int[]{5};
        int[] result7 = new Solution().solution(progresses7, speeds7);
        PRINT_RESULT(7, result7, answer7);

        int[] progresses8 = new int[]{20, 99, 93, 30, 55, 10};
        int[] speeds8 = new int[]{5, 10, 1, 1, 30, 5};
        int[] answer8 = new int[]{3, 3};
        int[] result8 = new Solution().solution(progresses8, speeds8);
        PRINT_RESULT(8, result8, answer8);

        int[] progresses9 = new int[]{1, 1, 1, 1};
        int[] speeds9 = new int[]{100, 50, 99, 100};
        int[] answer9 = new int[]{1, 3};
        int[] result9 = new Solution().solution(progresses9, speeds9);
        PRINT_RESULT(9, result9, answer9);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[101];

        int prev = 0;
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) day++;

            if (i != 0 && prev > day) day = prev;
            days[day]++;
            prev = day;
        }

        List<Integer> answer = new ArrayList<>();
        for (int day : days) {
            if (day != 0) {
                answer.add(day);
            }
        }

        return answer.isEmpty()
                ? new int[]{0}
                : answer.stream().mapToInt(Integer::intValue).toArray();
    }
}