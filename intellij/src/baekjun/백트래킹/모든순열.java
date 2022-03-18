package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 모든순열 {
    static int N;
    static int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
    static int[] arr;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isVisited = new boolean[N];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int length) {
        if (length >= N) {
            for (int i : arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            arr[length] = num[i];
            dfs(length + 1);
            isVisited[i] = false;
        }
    }
}
