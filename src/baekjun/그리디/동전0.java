package src.baekjun.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] cash = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            cash[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            while (true) {
                if (K - cash[i] >= 0) {
                    K -= cash[i];
                    result++;
                } else break;
            }
            if (K == 0) break;
        }

        System.out.println(result);
    }
}
