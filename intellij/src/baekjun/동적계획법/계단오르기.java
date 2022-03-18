package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 계단오르기
 * https://www.acmicpc.net/problem/2579
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-03-31
 */
public class 계단오르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N >= 1)
            ans[1] = stairs[1];
        if (N >= 2)
            ans[2] = Math.max(stairs[1] + stairs[2], stairs[2]);
        if (N >= 3)
            ans[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        if (N >= 4) {
            for (int i = 4; i <= N; i++) {
                ans[i] = Math.max(ans[i - 3] + stairs[i] + stairs[i - 1], ans[i - 2] + stairs[i]);
            }
        }

        System.out.println(ans[N]);
    }
}
