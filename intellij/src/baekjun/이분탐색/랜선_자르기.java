package src.baekjun.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 랜선_자르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        long min = 1;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }


        while (min <= max) {
            long mid = (min + max) >> 1;

            int count = 0;
            for (int a : arr) {
                count += (int) (a / mid);
            }

            if (count >= n) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min - 1);
    }
}

