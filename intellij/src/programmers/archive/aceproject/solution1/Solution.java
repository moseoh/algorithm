package src.programmers.archive.aceproject.solution1;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] v = new int[]{1, 2, 1, 2, 1};
        int answer1 = 2;
        int result1 = new Solution().solution(n, v);
        System.out.println(answer1);
        System.out.println(result1);
    }

    public int solution(int n, int[] v) {
        int leftSum = 0;
        int rightSum = 0;
        for (int num : v) {
            rightSum += num;
        }

        int answer = 0;
        int min = Math.abs(leftSum - rightSum);

        for (int i = 0; i < n; i++) {
            leftSum += v[i];
            rightSum -= v[i];

            if (Math.abs(leftSum - rightSum) < min) {
                min = Math.abs(leftSum - rightSum);
                answer = i + 1;
            }
        }

        return answer;
    }
}
