package src.programmers.test.num2;

public class Solution {
    public static void main(String[] args) {
        String[] grid = {".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###..."};
        System.out.println(solution(grid));
    }

    public static int solution(String[] grid) {
        char[][] gridArray = new char[grid.length][grid[0].length()];
        for (int i = 0; i < gridArray.length; i++) {
            gridArray[i] = grid[i].toCharArray();
        }

        int count = 0;
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                isBlock(gridArray, j, i);
                if (gridArray[i][j] == '#') count++;
            }
        }
        return count;
    }

    private static void isBlock(char[][] gridArray, int indexX, int indexY) {

        if (gridArray[indexY][indexX] == '#') return;
        // 오른쪽
        for (int i = indexX; i < gridArray[indexY].length; i++) {
            if (gridArray[indexY][i] == '#') break;
            if (gridArray[indexY][i] == '-') {
                gridArray[indexY][indexX] = '-';
                return;
            }
            if (i == gridArray[indexY].length - 1) {
                gridArray[indexY][indexX] = '-';
                return;
            }
        }

        // 왼쪽
        for (int i = indexX; i >= 0; i--) {
            if (gridArray[indexY][i] == '#') break;
            if (gridArray[indexY][i] == '-') {
                gridArray[indexY][indexX] = '-';
                return;
            }
            if (i == 0) {
                gridArray[indexY][indexX] = '-';
                return;
            }
        }

        // 위
        for (int i = indexY; i < gridArray.length; i++) {
            if (gridArray[i][indexX] == '#') break;
            if (gridArray[i][indexX] == '-') {
                gridArray[indexY][indexX] = '-';
                return;
            }
            if (i == gridArray.length - 1) {
                gridArray[indexY][indexX] = '-';
                return;
            }
        }

        // 아래
        for (int i = indexY; i >= 0; i--) {
            if (gridArray[i][indexX] == '#') break;
            if (gridArray[i][indexX] == '-') {
                gridArray[indexY][indexX] = '-';
                return;
            }
            if (i == 0) {
                gridArray[indexY][indexX] = '-';
                return;
            }
        }

        gridArray[indexY][indexX] = '#';
    }
}
