package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 파도반수열
 * https://www.acmicpc.net/problem/9461
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-03-31
 */
public class 파도반수열 {
    static long[] ans = new long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ans[1] = 1;
        ans[2] = 1;
        ans[3] = 1;
        ans[4] = 2;
        ans[5] = 2;
        for (int i = 6; i <= 100; i++) {
            ans[i] = ans[i - 1] + ans[i - 5];
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }
}
