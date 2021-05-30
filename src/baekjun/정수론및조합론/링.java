package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링
 * https://www.acmicpc.net/problem/3036
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 링 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())-1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            int num = Integer.parseInt(st.nextToken());
            int gcd = gcd(first, num);
            sb.append(first/gcd).append("/").append(num/gcd).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if( b == 0) return a;
        else return gcd(b, a % b);
    }
}
