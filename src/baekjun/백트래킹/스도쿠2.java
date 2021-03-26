package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스도쿠2 {
    static int[][] sudoku = new int[9][9];
    static List<int[]> list = new ArrayList<>();
    static boolean check;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 9; k++) {
                sudoku[i][k] = Integer.parseInt(st.nextToken());
                if (sudoku[i][k] == 0) {
                    list.add(new int[]{i, k});
                }
            }
        }

        backTracking(0, 0);
    }


    static void backTracking(int index, int count) {
        // 완성
        if (list.size() == count) {
            StringBuilder sb = new StringBuilder();
            for (int[] b : sudoku) {
                for (int a : b) sb.append(a).append(" ");
                sb.append("\n");
            }
            System.out.println(sb);
            check = true;
            return;
        }

        if(check) return;

        // 실패
        if (index >= list.size())
            return;

        int row = list.get(index)[0];
        int col = list.get(index)[1];

        for(int i = 1; i <= 9; i++) {
            if(check(row,col,i)) {
                sudoku[row][col] = i;
                backTracking(index+1, count +1);
                sudoku[row][col] = 0;
            }
        }
    }

    static boolean check(int row, int col, int num) {
            for (int i = 0; i < 9; i++) {
                if (sudoku[row][i] == num) return false;
                if (sudoku[i][col] == num) return false;
            }

            int tempRow = row / 3 * 3;
            int tempCol = col / 3 * 3;

            for (int i = tempRow; i < tempRow + 3; i++) {
                for (int k = tempCol; k < tempCol + 3; k++) {
                    if (sudoku[i][k] == num) return false;
                }
            }

        return true;
    }
}
