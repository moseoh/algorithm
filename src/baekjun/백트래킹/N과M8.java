package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M8 {
    static int N, M;
    static int[] inputArr, outputArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputArr = new int[N];
        outputArr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);

        dfs(0,0);

        System.out.println(sb);
    }

    static void dfs(int at, int length) {
        if (length == M) {
            for (int i = 0; i < M; i++) sb.append(outputArr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = at ; i < N; i++) {
            outputArr[length] = inputArr[i];
            dfs(i, length+1);
        }
    }
}
