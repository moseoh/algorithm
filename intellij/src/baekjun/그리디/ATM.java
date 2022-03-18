package src.baekjun.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * ATM
 * https://www.acmicpc.net/problem/11399
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-27
 */
public class ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] num = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            result += num[i] * (N - i);
        }

        System.out.println(result);
    }
}
