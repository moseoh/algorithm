package src.leetcode.topinterview150.search_a_2d_matrix;

class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}, {3}};
        int target = 3;
        boolean result = new Solution().searchMatrix(matrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix.length - 1 || (matrix[i][0] <= target && target < matrix[i + 1][0])) {
                index = i;
                break;
            }
        }

        for (int j = 0; j < matrix[index].length; j++) {
            if (matrix[index][j] == target) return true;
        }

        return false;
    }
}