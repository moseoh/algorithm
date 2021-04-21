package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = Integer.MIN_VALUE;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, 1 << board[0][0] - 'A', 1);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int bit, int cnt) {
        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (moveX < R && moveY < C && moveX >= 0 && moveY >= 0 &&
                    ((bit & 1 << board[moveX][moveY] - 'A') == 0)){
                dfs(moveX, moveY, bit | 1 << board[moveX][moveY] - 'A', cnt + 1);
            }
        }
        ans = Math.max(ans, cnt);
    }

}
