package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen {
    static int N;
    static int[] col;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int row) {
        if(row == N) {
            result++;
            return;
        }

        for(int i = 0; i < N; i++ ) {
            col[row] = i;
            if(isPossible(row )) {
                dfs(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for(int i = 0; i< row; i++) {
            if(col[i] == col[row]) return false;
            if(Math.abs(col[i] - col[row]) == Math.abs(i - row)) return false;
        }
        return true;
    }
}
