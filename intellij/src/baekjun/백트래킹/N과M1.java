package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M1 {
    static int N, len;
    static int[] num;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        num = new int[N + 1];

        System.out.println(dfs(0, new StringBuilder()));
    }

    static StringBuilder dfs(int pos, StringBuilder sb) {
        if (pos == len) {
            for(int i=0; i<len; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (isVisited[i]) continue;
                isVisited[i] = true;
                num[pos] = i;
                dfs(pos + 1, sb);
                isVisited[i] = false;
            }
        }
        return sb;
    }
}
