package src.baekjun.투_포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_고르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (left < N && right < N) {
            int diff = arr[right] - arr[left];
            if (diff == M) {
                answer = diff;
                break;
            }

            if (diff < M) {
                right++;
            } else {
                answer = Math.min(answer, diff);
                left++;
            }
        }

        System.out.println(answer);
    }
}
