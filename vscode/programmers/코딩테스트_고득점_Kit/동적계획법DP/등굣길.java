package programmers.코딩테스트_고득점_Kit.동적계획법DP;

public class 등굣길 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };
        Solution s = new Solution();
        System.out.println(s.solution(m, n, puddles));
    }

    static class Solution {
        int[][] area;

        public int solution(int m, int n, int[][] puddles) {
            area = new int[n][m];
            area[0][0] = 1;
            for (int[] puddle : puddles)
                area[puddle[1] - 1][puddle[0] - 1] = -1;

            for (int dept = 0; dept < n; dept++) {
                for (int index = 0; index < m; index++) {
                    if (area[dept][index] == -1) {
                        area[dept][index] = 0;
                        continue;
                    }

                    if (index != 0)
                        area[dept][index] += area[dept][index - 1];

                    if (dept != 0)
                        area[dept][index] += area[dept - 1][index];

                    area[dept][index] %= 1000000007;
                }
            }

            return area[n - 1][m - 1];
        }

        public void print(int[][] arr) {
            StringBuilder sb = new StringBuilder();
            for (int dept = 0; dept < arr.length; dept++) {
                for (int index = 0; index < arr[dept].length; index++) {
                    sb.append(arr[dept][index]);
                    sb.append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}