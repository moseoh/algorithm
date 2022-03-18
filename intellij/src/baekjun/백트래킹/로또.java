package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    static int N;
    static int[] num;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            num = new int[N];
            isUsed = new boolean[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            makeLotto(0, 0);
            System.out.println();
        }
    }

    static void makeLotto(int idx, int cnt) {
        if (cnt >= 6) {
            print();
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                makeLotto(i, cnt + 1);
                isUsed[i] = false;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (isUsed[i]) sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
    }
}
