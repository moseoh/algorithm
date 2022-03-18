package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static boolean[][] canPlaceQueen;
    static boolean[][] placeQueen;
    static int num;

    public static void main(String[] args) throws Exception {
//        run();
        test();
    }

    static void test() {
        num = 5;
        canPlaceQueen = new boolean[num][num];
        for (int i = 0; i < num; i++) for (int k = 0; k < num; k++) canPlaceQueen[i][k] = true;
        placeQueen = new boolean[num][num];

        placeQueen(3, 0);
        printChess();
    }

    static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // initialize
        // 1 = 1, 2 = 0, 3 = 0
        num = Integer.parseInt(br.readLine());
        canPlaceQueen = new boolean[num][num];
        for (int i = 0; i < num; i++) for (int k = 0; k < num; k++) canPlaceQueen[i][k] = true;
        placeQueen = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            for (int k = 0; k < num; k++) {
                if (canPlaceQueen[i][k]) {
                    placeQueen(i, k);
                    System.out.println("#" + i);
                    printChess();
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int k = 0; k < num; k++) {

            }
        }
    }

    static void placeQueen(int x, int y) {
        placeQueen[x][y] = true;
        setCanPlaceQueen(x, y);
    }

    static void setCanPlaceQueen(int x, int y) {
        for (int i = 0; i < num; i++) {
            canPlaceQueen[x][i] = false;
            canPlaceQueen[i][y] = false;
        }

        int tempX, tempY;
        // 왼쪽 대각선 왼쪽 끝 => x, y 둘중 하나가 0
        tempX = x;
        tempY = y;
        while (tempX-- > 0 && tempY-- > 0) {
            canPlaceQueen[tempX][tempY] = false;
        }

        // 왼쪽 대각선 오른쪽 끝 => x, y 둘중 하나가 num - 1
        tempX = x;
        tempY = y;
        while (tempX++ < num - 1 && tempY++ < num - 1) {
            canPlaceQueen[tempX][tempY] = false;
        }

        // 오른쪽 대각선 오른쪽 끝 => y가 0이거나 x가 num - 1
        tempX = x;
        tempY = y;
        while (tempX++ < num - 1 && tempY-- > 0) {
            canPlaceQueen[tempX][tempY] = false;
        }

        // 오른쪽 대각선 왼쪽 끝 => x가 0이거나 y가 num - 1
        tempX = x;
        tempY = y;
        while (tempX-- > 0 && tempY++ < num - 1) {
            canPlaceQueen[tempX][tempY] = false;
        }
    }

    static void printChess() {
        StringBuilder sb = new StringBuilder();

        sb.append("Place Queen").append("\n").append("\t");
        for(int i = 0; i < num; i++) sb.append(i).append("\t\t");
        sb.append("\n");
        for(int i = 0; i < num; i++){
            sb.append(i).append("\t");
            for (boolean k : placeQueen[i]) sb.append(k).append("\t");
            sb.append("\n");
        }

        sb.append("\n").append("Can Place Queen").append("\n").append("\t");
        for(int i = 0; i < num; i++) sb.append(i).append("\t\t");
        sb.append("\n");
        for(int i = 0; i < num; i++){
            sb.append(i).append("\t");
            for (boolean k : canPlaceQueen[i]) sb.append(k).append("\t");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
