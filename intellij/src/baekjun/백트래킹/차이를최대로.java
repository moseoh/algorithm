package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로 {
    static int N;
    static int[] num;
    static int[] arr;
    static boolean[] isVisited;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = new int[N];
        arr = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    static void dfs( int length) {
        if (length >= N) {
            int sum =0;
            for (int i = 0; i+1 <N ; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            ans = Math.max(ans,sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isVisited[i]){
                continue;
            }
            isVisited[i] =true;
            arr[length] = num[i];
            dfs(length+1);
            isVisited[i] =false;
        }
    }
}
