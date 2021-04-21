package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 전깃줄
 * https://www.acmicpc.net/problem/2565
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-01
 */
public class 전깃줄 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        int[] dp = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for (int i = 1; i <= n; i++) {
            dp[i]++;
            for (int k = 1; k <= i; k++) {
                if (arr[i][1] > arr[k][1]) dp[i] = Math.max(dp[i], dp[k] + 1);
            }

            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
    }
}
