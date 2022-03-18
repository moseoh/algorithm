package programmers.level_1;

public class 두_정수_사이의_합 {
    public static void main(String[] args) {
        int a = -10;
        int b = 10;

        System.out.println(new Solution().solution(a, b));
    }

    static class Solution {
        public long solution(int a, int b) {
            if (a == b)
                return a;

            int max = Math.max(a, b);
            int min = Math.min(a, b);
            long dif = max - min;

            return (dif * (dif + 1) / 2) + (min * (dif + 1));
        }
    }
}
