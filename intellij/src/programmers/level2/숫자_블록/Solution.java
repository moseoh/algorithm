package src.programmers.level2.숫자_블록;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        long begin1 = 100L;
//        long end1 = 110L;
//        int[] answer1 = new int[]{0, 1, 1, 2, 1, 3, 1, 4, 3, 5};
//        int[] result1 = new Solution().solution(begin1, end1);
//        PRINT_RESULT(1, result1, answer1);

        long begin1 = 1L;
        long end1 = 10L;
        int[] answer1 = new int[]{0, 1, 1, 2, 1, 3, 1, 4, 3, 5};
        int[] result1 = new Solution().solution(begin1, end1);
        PRINT_RESULT(1, result1, answer1);

        long begin2 = 999_999_998L;
//        long begin2 = 1_000_000_000L;
        long end2 = 1_000_000_000L;
        int[] answer2 = new int[]{1_447_178, 9_009_009, 10_000_000};
        int[] result2 = new Solution().solution(begin2, end2);
        PRINT_RESULT(2, result2, answer2);

        long begin3 = 9_999_999L;
        long end3 = 10_000_000L;
        int[] answer3 = new int[]{3_333_333, 5_000_000};
        int[] result3 = new Solution().solution(begin3, end3);
        PRINT_RESULT(3, result3, answer3);
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

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) getNum(begin + i);
        }

        return answer;
    }

    private static final long MAX_NUMBER = 10_000_000;

    public long getNum(long num) {
        if (num <= 1) return 0;
        List<Long> list = new ArrayList<>();

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);

                if ((num / i) <= MAX_NUMBER) {
                    list.add(num / i);
                }
            }
        }

        if (list.isEmpty()) return 1;

        list.sort(Long::compareTo);
        return list.get(list.size() - 1);
    }
}