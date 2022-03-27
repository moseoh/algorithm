package first;

public class test3 {
    public static void main(String[] args) {
        int width = 51;
        int height = 37;
        int[][] diagonals = { { 17, 19 } };

        Solution solution = new Solution();
        System.out.println(solution.solution(width, height, diagonals));
        // System.out.println(solution.cal(0, 0, 16, 19));
        // System.out.println(solution.cal(17, 18, 51, 37));
        // System.out.println(solution.cal(0, 0, 17, 18));
        // System.out.println(solution.cal(16, 19, 51, 37));
    }

    static class Solution {
        public long solution(int width, int height, int[][] diagonals) {
            long answer = 0;

            for (int[] d : diagonals) {
                answer += mod(mod(cal(0, 0, d[0] - 1, d[1])) * mod(cal(d[0], d[1] - 1, width, height)));
                answer += mod(mod(cal(0, 0, d[0], d[1] - 1)) * mod(cal(d[0] - 1, d[1], width, height)));
            }

            return mod(answer);
        }

        public long cal(int fromX, int fromY, int toX, int toY) {
            long a = toX - fromX;
            long b = toY - fromY;
            long c = a + b;

            long xa = 1;
            long xb = 1;
            long xc = 1;

            for (long i = 1; i <= c; i++) {
                xc = mod(mod(i) * mod(xc));
            }

            for (long i = 1; i <= b; i++) {
                xb = mod(mod(i) * mod(xb));
            }

            for (long i = 1; i <= a; i++) {
                xa = mod(mod(i) * mod(xa));
            }

            xb = mod(mod(xb) * mod(xa));

            return mod(mod(xc) * (mod(xb) + 1));

            // if (Math.max(a, b) == a) {
            // int temp = b;
            // b = a;
            // a = temp;
            // }

            // int s = 1;
            // int p = 1;

            // for (int i = c; i > b; i--) {
            // s = mod(mod(s) * mod(i));
            // }

            // for (int i = 1; i <= a; i++) {
            // p = mod(mod(p) * mod(i));
            // }
            // p = mod(mod(p) + mod(1));

            // return mod(mod(s) * mod(p));
        }

        public long mod(long m) {
            return m % 10000019;
        }
    }
}
