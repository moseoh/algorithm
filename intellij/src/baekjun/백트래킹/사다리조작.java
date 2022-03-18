package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {
    static int N, M, H;
    static boolean[][] ladder;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x][y] = true;
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }
        System.out.println("ans : " + ans);
    }

    static void dfs(int startPos) {
        if (ans > 3) ans = -1;
        if (ans == -1) return;
        if (isSamePos(startPos)) return;
        if (startPos > N) return;

        System.out.println("startPos : " + startPos);
        System.out.println("ans : " + ans);
        System.out.println("N : " + N);
        print();

        // 선추가하기
        // 오른쪽 끝은 선 추가 불가
        for (int i = 1; i < H; i++) {
            if (isPossible(i, startPos)) {
                ladder[i][startPos] = true;
                ans++;
                dfs(startPos);
            }

            if(isSamePos(startPos)) continue;
            ladder[i][startPos] = false;
            ans--;
        }
    }

    static boolean isSamePos(int startPos) {
        int pos = startPos;
        for (int i = 1; i <= H; i++) {
            if (ladder[i][pos]) {
                pos++;
            } else if (ladder[i][pos - 1]) {
                pos--;
            }
        }

        return startPos == pos;
    }

    static boolean isPossible(int x, int y) {
        // 상
        if (x - 1 >= 0)
            if (ladder[x - 1][y]) return false;
        // 하
        if (x + 1 <= H)
            if (ladder[x + 1][y]) return false;
        // 좌
        if (y - 1 >= 0)
            if (ladder[x][y - 1]) return false;
        // 우
        if (y + 1 <= N)
            if (ladder[x][y + 1]) return false;

        // 현재 위치
        return !ladder[x][y];
    }

    static void print() {
        for (boolean[] b : ladder) {
            for (boolean a : b) System.out.print(a + "\t");
            System.out.println();
        }
        System.out.println();
    }
}
