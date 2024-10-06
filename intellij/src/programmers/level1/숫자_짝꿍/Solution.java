package src.programmers.level1.숫자_짝꿍;

class Solution {
    public static void main(String[] args) {
//        String X1 = "100";
//        String Y1 = "2345";
//        String answer1 = "-1";
//        String result1 = new Solution().solution(X1, Y1);
//        PRINT_RESULT(1, result1, answer1);

        String X2 = "100";
        String Y2 = "203045";
        String answer2 = "0";
        String result2 = new Solution().solution(X2, Y2);
        PRINT_RESULT(2, result2, answer2);

        String X3 = "100";
        String Y3 = "123450";
        String answer3 = "10";
        String result3 = new Solution().solution(X3, Y3);
        PRINT_RESULT(3, result3, answer3);

        String X4 = "12321";
        String Y4 = "42531";
        String answer4 = "321";
        String result4 = new Solution().solution(X4, Y4);
        PRINT_RESULT(4, result4, answer4);

        String X5 = "5525";
        String Y5 = "1255";
        String answer5 = "552";
        String result5 = new Solution().solution(X5, Y5);
        PRINT_RESULT(5, result5, answer5);
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

    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] has = new int[10];
        int[] arr = new int[10];

        for (char c : Y.toCharArray()) {
            has[Character.getNumericValue(c)]++;
        }

        for (char c : X.toCharArray()) {
            int num = Character.getNumericValue(c);
            if (has[num] > 0) {
                has[num]--;
                arr[num]++;
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (arr[i] == 0) {
                continue;
            }

            answer.append(i);
            arr[i]--;
            i++;
        }

        if (answer.length() == 0) {
            return "-1";
        } else if (answer.toString().matches("^0*$")) {
            return "0";
        } else {
            return answer.toString();
        }
    }
}