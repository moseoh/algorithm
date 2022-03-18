package programmers.level_1;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

        System.out.println(new Solution().solution(sizes));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int width = 0;
            int height = 0;

            for (int i = 0; i < sizes.length; i++) {
                width = Math.max(width, Math.max(sizes[i][0], sizes[i][1]));
                height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
            }

            return width * height;
        }
    }
}
