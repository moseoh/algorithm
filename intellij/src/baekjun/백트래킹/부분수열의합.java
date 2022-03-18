package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {
    static int N, S;
    static int[] num;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        calSubSequence(0, 0);
        if (S == 0) ans--;
        System.out.println(ans);
    }

    static void calSubSequence(int total, int depth) {

        if (depth == N) {
            if (total == S) ans++;
            return;
        }

        calSubSequence(total + num[depth], depth + 1);
        calSubSequence(total, depth + 1);
    }
}
