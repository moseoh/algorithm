package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
    static int N, len;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        num = new int[len];
        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int at, int pos) {
        if (pos == len) {
            for (int i = 0; i < len; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            num[pos] = i;
            dfs(i + 1, pos + 1);
        }
    }
}
