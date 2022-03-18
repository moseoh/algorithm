package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 약수
 * https://www.acmicpc.net/problem/1037
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-29
 */
public class 약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);
        int result;
        if(N % 2 == 0) {
            result = num[N/2-1] * num[N/2];
        } else {
            result = num[N/2] * num[N/2];
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
