package src.programmers.level2.구명보트;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] people1 = new int[]{70, 50, 80, 50};
        int limit1 = 100;
        int answer1 = 3;
        int result1 = new Solution().solution(people1, limit1);
        PRINT_RESULT(1, result1, answer1);

        int[] people2 = new int[]{70, 80, 50};
        int limit2 = 100;
        int answer2 = 3;
        int result2 = new Solution().solution(people2, limit2);
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int index = people.length - 1;
        for (int i = 0; i <= index; i++, answer++)
            while (index > i && people[i] + people[index--] > limit)
                answer++;

        return answer;
    }
}