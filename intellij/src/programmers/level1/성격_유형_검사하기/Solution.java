package src.programmers.level1.성격_유형_검사하기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] survey1 = new String[]{"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = new int[]{5, 3, 2, 7, 5};
        String answer1 = "TCMA";
        String result1 = new Solution().solution(survey1, choices1);
        PRINT_RESULT(1, result1, answer1);

        String[] survey2 = new String[]{"TR", "RT", "TR"};
        int[] choices2 = new int[]{7, 1, 3};
        String answer2 = "RCJA";
        String result2 = new Solution().solution(survey2, choices2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    private static final char[][] METRIC = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Map<Character, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            int c = choices[i] - 4;
            if (c < 0) {
                scoreMap.merge(survey[i].charAt(0), c * -1, Integer::sum);
            } else if (c > 0) {
                scoreMap.merge(survey[i].charAt(1), c, Integer::sum);
            }
        }

        for (char[] chars : METRIC) {
            int a = scoreMap.getOrDefault(chars[0], 0);
            int b = scoreMap.getOrDefault(chars[1], 0);

            if (a > b) {
                answer.append(chars[0]);
            } else if (a < b) {
                answer.append(chars[1]);
            } else {
                answer.append(chars[0]);
            }
        }

        return answer.toString();
    }
}