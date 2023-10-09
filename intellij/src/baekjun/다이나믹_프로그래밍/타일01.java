package src.baekjun.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 타일01 https://www.acmicpc.net/problem/1904 Github : https://github.com/azqazq195 Created by
 * azqazq195@gmail.com on 2021-03-31
 */

public class 타일01 {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(dp(N));
    }

    static int dp(int n) {
        int sum = 1;
        int add = 0;
        int temp = 0;
        while (n-- > 0) {
            temp = sum;
            sum += add;
            add = temp;
            sum %= 15746;
        }
        return sum;
    }
}
