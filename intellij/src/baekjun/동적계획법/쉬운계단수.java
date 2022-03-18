package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 쉬운계단수
 * https://www.acmicpc.net/problem/10844
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-03-31
 */
public class 쉬운계단수 {
    final static long mod = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] num = new long[N][10];

        // 1
        for (int i = 1; i < 10; i++) {
            num[0][i]++;
        }

        for (int i = 1; i < N; i++) {
            for (int k = 0; k < 10; k++) {
                // 0일때
                if (k == 0) num[i][k] = num[i - 1][1] % mod;
                    // 9일때
                else if (k == 9) num[i][k] = num[i - 1][8] % mod;
                // 그외
                else num[i][k] = (num[i-1][k-1] + num[i-1][k+1]) % mod;
            }
        }

        long result = 0;
        for(int i = 0; i < 10; i ++) {
            result += num[N-1][i];
        }
        System.out.println(result % mod);
    }
}
