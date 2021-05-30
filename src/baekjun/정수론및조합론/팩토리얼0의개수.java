package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 팩토리얼0의개수
 * https://www.acmicpc.net/problem/1676
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-31
 */
public class 팩토리얼0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 125 == 0)
                count+=3;
            else if (i % 25 == 0)
                count+=2;
            else if(i % 5 == 0)
                count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
