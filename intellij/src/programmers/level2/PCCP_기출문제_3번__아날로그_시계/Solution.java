package src.programmers.level2.PCCP_기출문제_3번__아날로그_시계;

class Solution {
    public static void main(String[] args) {
        int h11 = 0;
        int m11 = 5;
        int s11 = 30;
        int h21 = 0;
        int m21 = 7;
        int s21 = 0;
        int answer1 = 2;
        int result1 = new Solution().solution(h11, m11, s11, h21, m21, s21);
        PRINT_RESULT(1, result1, answer1);

        int h12 = 12;
        int m12 = 0;
        int s12 = 0;
        int h22 = 12;
        int m22 = 0;
        int s22 = 30;
        int answer2 = 1;
        int result2 = new Solution().solution(h12, m12, s12, h22, m22, s22);
        PRINT_RESULT(2, result2, answer2);

        int h13 = 0;
        int m13 = 6;
        int s13 = 1;
        int h23 = 0;
        int m23 = 6;
        int s23 = 6;
        int answer3 = 0;
        int result3 = new Solution().solution(h13, m13, s13, h23, m23, s23);
        PRINT_RESULT(3, result3, answer3);

        int h14 = 11;
        int m14 = 59;
        int s14 = 30;
        int h24 = 12;
        int m24 = 0;
        int s24 = 0;
        int answer4 = 1;
        int result4 = new Solution().solution(h14, m14, s14, h24, m24, s24);
        PRINT_RESULT(4, result4, answer4);

        int h15 = 11;
        int m15 = 58;
        int s15 = 59;
        int h25 = 11;
        int m25 = 59;
        int s25 = 0;
        int answer5 = 1;
        int result5 = new Solution().solution(h15, m15, s15, h25, m25, s25);
        PRINT_RESULT(5, result5, answer5);

        int h16 = 1;
        int m16 = 5;
        int s16 = 5;
        int h26 = 1;
        int m26 = 5;
        int s26 = 6;
        int answer6 = 2;
        int result6 = new Solution().solution(h16, m16, s16, h26, m26, s26);
        PRINT_RESULT(6, result6, answer6);

        int h17 = 0;
        int m17 = 0;
        int s17 = 0;
        int h27 = 23;
        int m27 = 59;
        int s27 = 59;
        int answer7 = 2852;
        int result7 = new Solution().solution(h17, m17, s17, h27, m27, s27);
        PRINT_RESULT(7, result7, answer7);
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

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTime = toSec(h1, m1, s1);
        int endTime = toSec(h2, m2, s2);

        int num = endTime * 59 / 3600 + endTime * 719 / 43200 - startTime * 59 / 3600 - startTime * 719 / 43200;
        if (startTime >= 43200) {
            num += 1;
        }
        if (endTime >= 43200) {
            num -= 1;
        }
        if (startTime * 59 % 3600 == 0 || startTime * 719 % 43200 == 0) {
            num += 1;
        }

        return num;
    }

    private static int toSec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

}