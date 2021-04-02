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

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1 ; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w[i] =  Integer.parseInt(st.nextToken());
            v[i] =  Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1;  j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(w[i] <= j) dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
            }
        }

        System.out.println(dp[n][k]);


    }
}
