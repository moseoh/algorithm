package src.programmers.level1.시저_암호;

class Solution {
    public static void main(String[] args) {
        String s1 = "AB";
        int n1 = 1;
        String answer1 = "BC";
        String result1 = new Solution().solution(s1, n1);
        PRINT_RESULT(1, result1, answer1);

        String s2 = "z";
        int n2 = 1;
        String answer2 = "a";
        String result2 = new Solution().solution(s2, n2);
        PRINT_RESULT(2, result2, answer2);

        String s3 = "a B z";
        int n3 = 4;
        String answer3 = "e F d";
        String result3 = new Solution().solution(s3, n3);
        PRINT_RESULT(3, result3, answer3);
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

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer.append(" ");
            } else {
                char base = (c >= 'a') ? 'a' : 'A';
                int shifted = (c - base + n) % 26 + base;
                answer.append((char) shifted);
            }
        }

        return answer.toString();
    }
}