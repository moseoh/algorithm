package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최대공약수와최소공배수
 * https://www.acmicpc.net/problem/2609
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 최대공약수와최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[2];
        num[0] = Integer.parseInt(st.nextToken());
        num[1] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);

        int gcd = gcd(num[0], num[1]);
        int lcm = lcm(num[0], num[1]);

        System.out.println(gcd + "\n" + lcm);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
