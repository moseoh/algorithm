package programmers.level_1;

public class 나머지가_1이_되는_수_찾기 {
    public static void main(String[] args) {
        int n = 12;

        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;
            int p = Integer.MAX_VALUE;
            for (int i = n - 1; i > 0; i--) {
                if (p >= n % i && n % i != 0) {
                    answer = i;
                    p = n % i;
                }
            }
            return answer;
        }
    }
}
