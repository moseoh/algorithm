package src.leetcode.devclub.maximal_square;

public class Solution {
    public static void main(String[] args) {
//        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};

        int result = new Solution().maximalSquare(matrix);
        System.out.println(result);
    }


    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                if (matrix[i - 1][k - 1] == '1') {
                    dp[i][k] = Math.min(dp[i - 1][k - 1], Math.min(dp[i][k - 1], dp[i - 1][k])) + 1;
                    result = Math.max(dp[i][k], result);
                }
            }
        }

        return result * result;
    }
}