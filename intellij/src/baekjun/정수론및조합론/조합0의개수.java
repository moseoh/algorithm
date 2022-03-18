package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 조합0의개수
 * https://www.acmicpc.net/problem/2004
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-31
 */
public class 조합0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int five = 0;

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        int count5 = five_power(n) - five_power(n - m) - five_power(m);
        int count2 = two_power(n) - two_power(n - m) - two_power(m);

        bw.write(String.valueOf(Math.min(count5, count2)));
        bw.flush();
        bw.close();
    }

    static int five_power(long num) {
        int count = 0;
        while(num >= 5) {
            count += num/5;
            num /= 5;
        }
        return count;
    }

    static int two_power(long num) {
        int count = 0;
        while(num >= 2) {
            count += num/2;
            num /= 2;
        }
        return count;
    }
}
