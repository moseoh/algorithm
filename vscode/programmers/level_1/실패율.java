package programmers.level_1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = { 1, 1, 1, 1, 1, 1 };

        System.out.println(Arrays.toString(new Solution().solution(N, stages)));
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] goals = new int[N];
            for (int stage : stages) {
                if (stage > N)
                    continue;
                goals[stage - 1]++;
            }

            double[] failureRates = new double[N];
            int people = stages.length;
            TreeSet<Double> set = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                if (goals[i] == 0) {
                    failureRates[i] = 0;
                } else {
                    failureRates[i] = goals[i] / (double) people;
                }
                people -= goals[i];
                set.add(failureRates[i]);
            }

            int[] answer = new int[N];
            int index = 0;
            for (Double failureRate : (TreeSet<Double>) set.descendingSet()) {
                System.out.println(failureRate);
                for (int i = 0; i < failureRates.length; i++) {
                    if (failureRate == failureRates[i]) {
                        answer[index] = i + 1;
                        index++;
                    }
                }
            }

            return answer;
        }
    }
}

/*
 * 1 2 3 4 6
 * 2 3
 * 2
 * 
 * 1/8
 * 3/7
 * 2/4
 * 1/2
 * 0/1
 */
