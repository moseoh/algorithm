package study.week3.example2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    public static void main(String[] args) {
        int[][] maps = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };

        // int[][] maps = {
        // { 1, 0, 1, 1, 1 },
        // { 1, 0, 1, 0, 1 },
        // { 1, 0, 1, 1, 1 },
        // { 1, 1, 1, 0, 1 },
        // { 0, 0, 0, 0, 1 },
        // };

        // int[][] maps = {
        // { 1, 0, 1, 1, 1 },
        // { 1, 0, 1, 0, 1 },
        // { 1, 0, 1, 1, 1 },
        // { 1, 1, 1, 0, 0 },
        // { 0, 0, 0, 0, 1 },
        // };

        Solution s = new Solution();
        System.out.println(s.solution(maps));
    }

}

class Solution {
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public int solution(int[][] maps) {
        return bfs(maps, maps.length, maps[0].length, 0);
    }

    // 너비 우선 탐색
    public int bfs(int[][] maps, int n, int m, int count) {
        Queue<int[]> que = new LinkedList<>();
        // x, y, distance
        int[] node = new int[] { 0, 0, 1 };
        que.add(node);
        maps[0][0] = 0;
        while (!que.isEmpty()) {
            node = que.poll();

            if (node[0] == n - 1 && node[1] == m - 1) {
                return node[2];
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = node[0] + dx[i];
                int nextY = node[1] + dy[i];

                if (!isMovable(maps, n, m, nextX, nextY))
                    continue;

                que.add(new int[] { nextX, nextY, node[2] + 1 });
                maps[nextX][nextY] = 0;
            }
        }
        return -1;
    }

    public void print(int[][] maps, int[] node) {
        StringBuilder sb = new StringBuilder();
        sb.append("node: ");
        sb.append(node[2]);
        sb.append("\n");
        for (int i = 0; i < maps.length; i++) {
            for (int k = 0; k < maps[i].length; k++) {
                if (i == node[0] && k == node[1]) {
                    sb.append("x");
                } else {
                    sb.append(maps[i][k]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public boolean isMovable(int[][] maps, int n, int m, int x, int y) {
        if (n <= x || x < 0 || m <= y || y < 0)
            return false;

        if (maps[x][y] == 0)
            return false;

        return true;
    }

    // 깊이 우선 이건 도달할 수 있는 길의 가지 수 구할 때 쓰던가
    // 효율성 탈락

    // public void dfs(int[][] maps, int n, int m, int x, int y, int count) {
    // count++;

    // for (int i = 0; i < dx.length; i++) {
    // int nextX = x + dx[i];
    // int nextY = y + dy[i];

    // if (!isMovableDfs(maps, n, m, nextX, nextY)) {
    // continue;
    // }
    // maps[x][y] = 0;
    // dfs(maps, n, m, nextX, nextY, count);
    // maps[x][y] = 1;
    // }

    // if (n - 1 == x && m - 1 == y) {
    // answer = answer == -1 ? count : Math.min(answer, count);
    // }
    // }
}