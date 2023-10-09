package src.baekjun.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속합 https://www.acmicpc.net/problem/1912 Github : https://github.com/azqazq195 Created by
 * azqazq195@gmail.com on 2021-04-01
 */
public class 연속합 {

    static int[] num, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp[i] = num[i];
            } else {
                dp[i] = Math.max(num[i] + dp[i - 1], num[i]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
