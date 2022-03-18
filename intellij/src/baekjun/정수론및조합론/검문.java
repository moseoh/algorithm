package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 검문
 * https://www.acmicpc.net/problem/2981
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 검문 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int gcd = nums[1]-nums[0];
        for (int i = 2; i < N; i++) {
            gcd = gcd(gcd, nums[i] - nums[i-1]);
        }

        ArrayList<Integer> divider = new ArrayList<>();
        ArrayList<Integer> divider_r = new ArrayList<>();
        for (int div = 2; div <= Math.sqrt(gcd); div++) {
            if (gcd % div == 0) {
                if (div == Math.sqrt(gcd)) {
                    divider.add(div);
                    break;
                }
                divider.add(div);
                divider_r.add(gcd / div);
            }
        }
        Collections.reverse(divider_r);
        for (int a : divider) sb.append(a).append(" ");
        for (int a : divider_r) sb.append(a).append(" ");
        sb.append(gcd);

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
