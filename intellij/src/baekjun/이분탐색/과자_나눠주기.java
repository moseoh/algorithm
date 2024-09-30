package src.baekjun.이분탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 과자_나눠주기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int min = 1;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int result = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }

            if (count >= m) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}
