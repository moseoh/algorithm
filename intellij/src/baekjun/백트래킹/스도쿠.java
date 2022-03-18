package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스도쿠 {
    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 9; k++) {
                sudoku[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);

        StringBuilder sb = new StringBuilder();
        for (int[] b : sudoku) {
            for (int a : b) sb.append(a).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int row, int col) {
        for (int i = row; i < 9; i++) {
            for (int k = col; k < 9; k++) {
                if(sudoku[i][k] == 0) {
                    List<Integer> list = canNum(i, k);
                    if(list.size() == 0) {
                        return;
                    } else {
                        for(Integer num : list){
                            sudoku[i][k] = num;
                            dfs(i,k);
                        }
                    }
                }
            }
        }
    }

    static List<Integer> canNum(int row, int col) {
        List<Integer> canSetNum = new ArrayList<>();

        // 행 기준 가능한 숫자
        for (int num = 1; num <= 9; num++) {
            boolean check = false;
            for (int i = 0; i < 9; i++) {
                if (sudoku[row][i] == num) {
                    check = true;
                    break;
                }
            }
            // num 없음
            if (!check) canSetNum.add(num);
        }

        if(canSetNum.size() == 1) {
            return canSetNum;
        }

        // 열 기준 가능한 숫자
        List<Integer> temp = new ArrayList<>(canSetNum);
        canSetNum.clear();
        for (int num = 1; num <= 9; num++) {
            boolean check = false;
            for (int i = 0; i < 9; i++) {
                if (sudoku[i][col] == num) {
                    check = true;
                    break;
                }
            }
            // num 없음
            if (!check)
                if(temp.contains(num))
                    canSetNum.add(num);
        }


        if(canSetNum.size() == 1) {
            return canSetNum;
        }

        // 사각형 기준 가능한 숫자
        temp.clear();
        temp.addAll(canSetNum);
        canSetNum.clear();
        for (int num = 1; num <= 9; num++) {
            boolean check = false;
            int tempRow = row / 3 * 3;
            int tempCol = col / 3 * 3;
            for (int i = tempRow; i < tempRow + 3; i++) {
                for (int k = tempCol; k < tempCol + 3; k++) {
                    if(sudoku[i][k] == num) {
                        check = true;
                        break;
                    }
                }
            }
            // num 없음
            if (!check)
                if(temp.contains(num))
                    canSetNum.add(num);
        }

        return canSetNum;
    }
}
