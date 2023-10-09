package src.baekjun.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장긴바이토닉부분수열 https://www.acmicpc.net/problem/11054 Github : https://github.com/azqazq195 Created
 * by azqazq195@gmail.com on 2021-04-02
 */
public class 가장긴바이토닉부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        int[][] dp = new int[2][n + 1];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
            for (int k = 1; k <= i; k++) {
                if (num[k] < num[i]) {
                    dp[0][i] = Math.max(dp[0][k] + 1, dp[0][i]);
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            dp[1][i] = 1;
            for (int k = n; k >= i; k--) {
                if (num[k] < num[i]) {
                    dp[1][i] = Math.max(dp[1][k] + 1, dp[1][i]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[0][i] + dp[1][i] - 1, max);
        }

        System.out.println(max);
    }
}
