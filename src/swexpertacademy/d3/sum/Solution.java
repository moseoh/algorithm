package src.swexpertacademy.d3.sum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    static int MAX = 100;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d3/sum/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            System.out.print("#" + test_case + " ");
            br.readLine();
            int[][] arr = new int[MAX][MAX];
            // 정수 배열 만들기
            for (int i = 0; i < MAX; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < MAX; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }

            int max = 0;
            int sum;
            // 행의 최댓값
            for (int i = 0; i < MAX; i++) {
                sum = 0;
                for (int j = 0; j < MAX; j++) {
                    sum += arr[i][j];
                }
                if (sum > max) max = sum;
            }

            // 열의 최댓값
            for (int j = 0; j < MAX; j++) {
                sum = 0;
                for (int i = 0; i < MAX; i++) {
                    sum += arr[i][j];
                }
                if (sum > max) max = sum;
            }

            // 대각선의 최댓값
            // 왼쪽 -> 오른쪽
            sum = 0;
            for (int i = 0; i < MAX; i++) {
                sum += arr[i][i];
            }
            if (sum > max) max = sum;
            // 오른쪽 -> 왼쪽
            sum = 0;
            for (int i = 0; i < MAX; i++) {
                sum += arr[i][MAX - i - 1];
            }
            if (sum > max) max = sum;

            System.out.println(max);
        }
    }
}
