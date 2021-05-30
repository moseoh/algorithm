package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 이항계수2
 * https://www.acmicpc.net/problem/11051
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 이항계수2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] tri = new int[N + 1][N + 1];

        for (int i = 0; i < tri.length; i++)
            for (int k = 0; k <= i; k++) {
                if (i == k || k == 0)
                    tri[i][k] = 1;
                else
                    tri[i][k] = (tri[i - 1][k - 1] + tri[i - 1][k]) % 10007;
            }

        bw.write(String.valueOf(tri[N][K]));
        bw.flush();
        bw.close();
    }
}
