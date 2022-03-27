package first;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        int n = 6;
        boolean clockwise = false;

        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.solution(n, clockwise)));
    }

    static class Solution {
        public int[][] solution(int n, boolean clockwise) {
            int[][] answer = new int[n][n];

            int count = n % 2 == 1 ? n / 2 + 1 : n / 2;
            int index = 0;
            int length = n - index - 1;
            int num = 1;
            if (clockwise) {
                while (count-- != 0) {
                    for (int i = index; i < length; i++) {
                        answer[index][i] = num;
                        answer[i][length] = num;
                        answer[length][length + index - i] = num;
                        answer[length + index - i][index] = num;
                        num++;
                    }
                    index++;
                    length--;
                    if (index == length) {
                        answer[index][index] = num;
                    }
                }
            } else {
                while (count-- != 0) {
                    for (int i = index; i < length; i++) {
                        answer[index][length + index - i] = num;
                        answer[i][index] = num;
                        answer[length][i] = num;
                        answer[length + index - i][length] = num;
                        num++;
                    }
                    index++;
                    length--;
                    if (index == length) {
                        answer[index][index] = num;
                    }
                }
            }

            for (int[] as : answer) {
                for (int a : as) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            System.out.println();

            return answer;
        }
    }
}
