package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5 {
    static int N, M;
    static int[] inputArr;
    static int[] outputArr;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        inputArr = new int[N];
        isVisited = new boolean[N];
        outputArr = new int[M];
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr);
        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int length) {
        if (length == M) {
            for (int i : outputArr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            outputArr[length] = inputArr[i];
            dfs(length + 1);
            isVisited[i] = false;
        }
    }
}
