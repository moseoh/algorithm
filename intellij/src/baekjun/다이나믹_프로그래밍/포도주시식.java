package src.baekjun.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 포도주시식 https://www.acmicpc.net/problem/2156 Github : https://github.com/azqazq195 Created by
 * azqazq195@gmail.com on 2021-04-01
 */
public class 포도주시식 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = num[1];
        if (n >= 2) {
            dp[2] = num[1] + num[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + num[i]),
                dp[i - 3] + num[i - 1] + num[i]);
        }

        System.out.println(dp[n]);
    }
}
