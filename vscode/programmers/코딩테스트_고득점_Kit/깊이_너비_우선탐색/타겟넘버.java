package programmers.코딩테스트_고득점_Kit.깊이_너비_우선탐색;

public class 타겟넘버 {
    public static void main(String[] args) {
        // int[] numbers = { 1, 1, 1, 1, 1 };
        // int target = 3;
        int[] numbers = { 4, 1, 2, 1 };
        int target = 4;
        Solution s = new Solution();
        System.out.println(s.solution(numbers, target));
    }

    static class Solution {
        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(0, 0, numbers, target);
            return answer;
        }

        public void dfs(int index, int sum, int[] numbers, int target) {
            if (index == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                return;
            }

            dfs(index + 1, sum + numbers[index], numbers, target);
            dfs(index + 1, sum - numbers[index], numbers, target);
        }
    }
}
