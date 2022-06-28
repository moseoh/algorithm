package study.week1.example3;

import java.util.stream.*;

public class Budget {
    public static void main(String[] args) {
        int[] budgets = { 1, 1, 1, 1, 10 };
        int M = 5;
        Solution s = new Solution();
        System.out.println(s.solution(budgets, M));
    }

}

class Solution {
    public int solution(int[] budgets, int M) {
        int min = 0;
        int max = IntStream.of(budgets).max().orElse(0);

        int answer = 0;
        while (min <= max) {
            final int mid = (min + max) / 2;

            int sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }

            if (sum <= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }
}