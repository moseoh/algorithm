package study.week3.example3;

public class CorrectNumberOfBrackets {
    public static void main(String[] args) {
        int n = 13;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }

}

class Solution {
    public int solution(int n) {
        if (n <= 2)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
            dp[i] = i % 2 == 0 ? dp[i] * 2 : dp[i] * 2 + dp[i / 2] * dp[i / 2];
        }

        return dp[n];
    }
}

class Solution1 {
    int count;

    public int solution(int n) {
        count = 0;
        run(n, n, 0);
        return count;
    }

    public void run(int left, int right, int canRightCount) {
        if (left == 0 && right == 0) {
            count++;
            return;
        }

        if (canRightCount == 0) {
            run(left - 1, right, canRightCount + 1);
            return;
        }

        if (left > 0) {
            run(left - 1, right, canRightCount + 1);
        }

        if (right > 0) {
            run(left, right - 1, canRightCount - 1);
        }
    }
}
