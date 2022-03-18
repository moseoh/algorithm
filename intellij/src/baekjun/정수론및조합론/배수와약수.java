package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 배수와약수
 * https://www.acmicpc.net/problem/5086
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-29
 */
public class 배수와약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            if (b % a == 0) bw.write("factor\n");
            else if(a % b == 0) bw.write("multiple\n");
            else bw.write("neither\n");
        }
        bw.flush();
        bw.close();
    }
}
