package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평범한배낭
 * https://www.acmicpc.net/problem/12865
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-02
 */
public class 평범한배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] stuff = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(stuff[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stuff[i][0]] + stuff[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
