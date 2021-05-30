package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 이항계수1
 * https://www.acmicpc.net/problem/11050
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 이항계수1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 1;

        for (int i = 0; i < K; i++)
            result *= N - i;

        for (int i = K; i > 0; i--)
            result /= i;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
