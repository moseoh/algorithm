package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M3 {
    static int N, M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int pos) {
        if(pos == M) {
            for(int i : num) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i<= N; i++) {
            num[pos] = i;
            dfs(pos + 1);
        }
    }
}
