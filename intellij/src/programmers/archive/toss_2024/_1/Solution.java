package src.programmers.archive.toss_2024._1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 2, 1}, {4, 2, 0, 7, 1}, {1, 3, 2, 8, 1}, {2, 0, 1, 1, 1}, {8, 2, 1, 2, 1}};
        int[] entrancePoint = {4, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(a, entrancePoint));
    }

    boolean answer;
    boolean[][] visited;

    public boolean solution(int[][] a, int[] entrancePoint) {
        answer = false;
        visited = new boolean[a.length][a[0].length];
        visited[entrancePoint[0]][entrancePoint[1]] = true;

        move(a, entrancePoint[0], entrancePoint[1], 0);

        return answer;
    }

    public void move(int[][] a, int x, int y, int index) {
        if (answer || a[x][y] == 7) {
            answer = true;
            return;
        }

        if (index % 2 == 0) {
            for (int i = 1; y + i < a[0].length; i++) {
                int nextX = x;
                int nextY = y + i;


                if (!canMove(a, nextX, nextY)) {
                    break;
                }

                visited[nextX][nextY] = true;
                move(a, nextX, nextY, index + 1);
                visited[nextX][nextY] = false;
            }

            for (int i = 1; y - i < a[0].length; i++) {
                int nextX = x;
                int nextY = y - i;


                if (!canMove(a, nextX, nextY)) {
                    break;
                }

                visited[nextX][nextY] = true;
                move(a, nextX, nextY, index + 1);
                visited[nextX][nextY] = false;
            }
        } else {
            for (int i = 1; x + i < a.length; i++) {
                int nextX = x + i;
                int nextY = y;


                if (!canMove(a, nextX, nextY)) {
                    break;
                }

                visited[nextX][nextY] = true;
                move(a, nextX, nextY, index + 1);
                visited[nextX][nextY] = false;
            }

            for (int i = 1; x - i >= 0; i++) {
                int nextX = x - i;
                int nextY = y;


                if (!canMove(a, nextX, nextY)) {
                    break;
                }

                visited[nextX][nextY] = true;
                move(a, nextX, nextY, index + 1);
                visited[nextX][nextY] = false;
            }
        }


    }

    public boolean canMove(int[][] a, int nextX, int nextY) {
        if (nextX < 0 || nextX >= a.length || nextY < 0 || nextY >= a[0].length) {
            return false;
        }

        if (a[nextX][nextY] == 0 || a[nextX][nextY] == 8) {
            return false;
        }


        return !visited[nextX][nextY];
    }

    public void print(int[][] a) {
        for (int[] b : a) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }

    public void print(boolean[][] a) {
        for (boolean[] b : a) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }
}
