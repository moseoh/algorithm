package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 다리놓기
 * https://www.acmicpc.net/problem/1010
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 다리놓기 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bw.write(comb(m,n)+"\n");
        }
        bw.flush();
        bw.close();
    }

    static int comb(int n, int m) {
        if(dp[n][m] > 0) return dp[n][m];
        if (n == m || m == 0) return dp[n][m] = 1;
        return dp[n][m] = comb(n - 1, m - 1) + comb(n - 1, m);
    }
}
