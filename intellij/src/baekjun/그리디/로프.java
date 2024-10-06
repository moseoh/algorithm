package src.baekjun.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int answer = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {
//            min = Math.min(min, nums[i]); 이미 정렬된 상태라 min 을 구할 필요가 없음.
            answer = Math.max(answer, nums[
                    i] * (N - i));
        }

        System.out.println(answer);
    }
}
