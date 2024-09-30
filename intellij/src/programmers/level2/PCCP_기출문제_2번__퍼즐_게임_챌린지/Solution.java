package src.programmers.level2.PCCP_기출문제_2번__퍼즐_게임_챌린지;

class Solution {
    public static void main(String[] args) {
        int[] diffs1 = new int[]{1, 5, 3};
        int[] times1 = new int[]{2, 4, 7};
        long limit1 = 30L;
        int answer1 = 3;
        int result1 = new Solution().solution(diffs1, times1, limit1);
        PRINT_RESULT(1, result1, answer1);

        int[] diffs2 = new int[]{1, 4, 4, 2};
        int[] times2 = new int[]{6, 3, 8, 2};
        long limit2 = 59L;
        int answer2 = 2;
        int result2 = new Solution().solution(diffs2, times2, limit2);
        PRINT_RESULT(2, result2, answer2);

        int[] diffs3 = new int[]{1, 328, 467, 209, 54};
        int[] times3 = new int[]{2, 7, 1, 4, 3};
        long limit3 = 1723L;
        int answer3 = 294;
        int result3 = new Solution().solution(diffs3, times3, limit3);
        PRINT_RESULT(3, result3, answer3);

        int[] diffs4 = new int[]{1, 99999, 100000, 99995};
        int[] times4 = new int[]{9999, 9001, 9999, 9001};
        long limit4 = 3456789012L;
        int answer4 = 39354;
        int result4 = new Solution().solution(diffs4, times4, limit4);
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

    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (isPossible(diffs, times, mid, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    public boolean isPossible(int[] diffs, int[] times, long level, long limit) {
        long totalTime = times[0];
        for(int i=1; i<diffs.length; i++){
            if(diffs[i] > level){
                totalTime += (diffs[i] - level) * (times[i-1] + times[i]);
            }
            totalTime += times[i];
        }
        return totalTime <= limit;
    }
}