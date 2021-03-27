package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2 {
    static int N;
    static int[][] cost;
    static int[] arr;
    static boolean[] isVisited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isVisited = new boolean[N];
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k =0; k < N; k++) {
                cost[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        tsp(1);

        System.out.println(min);
    }

    static void tsp(int length) {
        if(length >= N) {
            int sum = 0;
            int temp = 0;
            for(int i = 0; i + 1 < N; i++) {
                temp = cost[arr[i]][arr[i+1]];
                if(temp == 0) return;
                sum += temp;
            }
            temp = cost[arr[N-1]][0];
            if(temp == 0) return;
            sum += temp;
            min = Math.min(min, sum);
            return;
        }

        for(int i = 1; i < N; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            arr[length] = i;
            tsp(length+1);
            isVisited[i] = false;
        }
    }
}
