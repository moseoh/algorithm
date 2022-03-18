package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장긴증가하는부분수열
 * https://www.acmicpc.net/problem/11053
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-01
 */
public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i]++;
        }

        int ans = 0;
        for(int i=0; i < n; i ++) {
            int max = 0;
            for(int k=0; k < i; k++) {
                if(num[i] > num[k]) max = Math.max(max, dp[k]);
            }
            dp[i] = max;
            dp[i]++;
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }
}
