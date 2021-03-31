package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 숫자1로만들기
 * https://www.acmicpc.net/problem/1463
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-03-31
 */
public class 숫자1로만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 0;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + 1;
                if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
