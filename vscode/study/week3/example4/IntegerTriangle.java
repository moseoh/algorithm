package study.week3.example4;

import java.util.Arrays;

public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {
                { 7 },
                { 3, 8 },
                { 8, 1, 0 },
                { 2, 7, 4, 4 },
                { 4, 5, 2, 6, 5 }
        };
        Solution s = new Solution();
        System.out.println(s.solution(triangle));
    }

}

class Solution {
    int[][] dp;

    public int solution(int[][] triangle) {
        int length = triangle[triangle.length - 1].length;
        dp = new int[length][length];
        dp(triangle);
        return Arrays.stream(dp[length - 1]).max().getAsInt();
    }

    public void dp(int[][] triangle) {
        for (int dept = 0; dept < triangle.length; dept++) {
            for (int index = 0; index < triangle[dept].length; index++) {
                dp[dept][index] = getMax(triangle, index, dept);
            }
        }
    }

    public int getMax(int[][] triangle, int index, int dept) {
        if (dept == 0) {
            return triangle[dept][0];
        }

        if (index == 0) {
            return dp[dept - 1][index] + triangle[dept][index];
        }

        if (index == triangle[dept].length - 1) {
            return dp[dept - 1][index - 1] + triangle[dept][index];
        }

        return Math.max(dp[dept - 1][index - 1], dp[dept - 1][index]) + triangle[dept][index];
    }
}