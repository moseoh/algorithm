package src.baekjun.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 피보나치함수 https://www.acmicpc.net/problem/1003 Github : https://github.com/azqazq195 Created by
 * azqazq195@gmail.com on 2021-03-30
 */

public class 피보나치함수 {

    static int[][] cnt = new int[41][2];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        dp();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(cnt[num][0]).append(" ").append(cnt[num][1]).append("\n");
        }

        System.out.println(sb);
    }

    static void dp() {
        for (int i = 0; i <= 40; i++) {
            if (i == 0) {
                cnt[i][0] = 1;
                cnt[i][1] = 0;
                continue;
            }

            if (i == 1) {
                cnt[i][0] = 0;
                cnt[i][1] = 1;
                continue;
            }

            cnt[i][0] = cnt[i - 1][0] + cnt[i - 2][0];
            cnt[i][1] = cnt[i - 1][1] + cnt[i - 2][1];
        }
    }
}
