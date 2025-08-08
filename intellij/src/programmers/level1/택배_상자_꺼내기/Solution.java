package src.programmers.level1.택배_상자_꺼내기;

class Solution {
    public static void main(String[] args) {
//        int n1 = 22;
//        int w1 = 6;
//        int num1 = 8;
//        int answer1 = 3;
//        int result1 = new Solution().solution(n1, w1, num1);
//        PRINT_RESULT(1, result1, answer1);

        int n2 = 13;
        int w2 = 3;
        int num2 = 6;
        int answer2 = 4;
        int result2 = new Solution().solution(n2, w2, num2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) {
            System.out.println(sb);
        } else {
            throw new RuntimeException(sb.toString());
        }
    }

    public int solution(int n, int w, int num) {
        int currentLineNumber = getLineNumber(w, num);
        int currentNumber = num;

        int count = 1;
        while (true) {
            int nextNumber = currentNumber + (w * currentLineNumber - currentNumber) * 2 + 1;
            if (nextNumber <= n) {
                count++;
                currentLineNumber++;
                currentNumber = nextNumber;
            } else {
                break;
            }
        }

        return count;
    }

    public int getLineNumber(int w, int num) {
        return (num - 1) / w + 1;
    }

}