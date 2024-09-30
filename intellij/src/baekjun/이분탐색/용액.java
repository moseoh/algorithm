package src.baekjun.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int ansLeft = left;
        int ansRight = right;

        while (left < right) {
            int diff = arr[left] + arr[right];

            if (Math.abs(diff) < Math.abs(arr[ansLeft] + arr[ansRight])) {
                ansLeft = left;
                ansRight = right;
            }

            if (diff < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.printf("%d %d\n", arr[ansLeft], arr[ansRight]);
    }
}
