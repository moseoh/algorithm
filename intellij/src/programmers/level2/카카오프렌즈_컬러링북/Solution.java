package src.programmers.level2.카카오프렌즈_컬러링북;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int m1 = 6;
        int n1 = 4;
        int[][] picture1 = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1},
            {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] result1 = new Solution().solution(m1, n1, picture1);
        int[] answer1 = new int[]{4, 5};
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) {
            System.out.println(sb);
        } else {
            throw new RuntimeException(sb.toString());
        }
    }

    final int[] dx = {1, 0, -1, 0};
    final int[] dy = {0, 1, 0, -1};
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    public int[] solution(int m, int n, int[][] picture) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    numberOfArea++;
                    tempSize = 0;
                    calcSize(i, j, picture[i][j], m, n, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempSize);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    int tempSize;

    public void calcSize(int x, int y, int color, int m, int n, int[][] picture) {
        tempSize++;
        picture[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX < 0 || nX >= m || nY < 0 || nY >= n) {
                continue;
            }

            if (color == picture[nX][nY]) {
                calcSize(nX, nY, color, m, n, picture);
            }
        }
    }
}