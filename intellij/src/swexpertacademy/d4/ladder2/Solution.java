package src.swexpertacademy.d4.ladder2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    static int MAX = 100;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/ladder2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            br.readLine();
            int[][] arr = new int[MAX][MAX];
            // 정수 배열 만들기
            for (int i = 0; i < MAX; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < MAX; j++) {
                    arr[j][i] = Integer.parseInt(temp[j]);
                }
            }

            // x 의 위치
            int x = 0;
            for (int i = 0; i < MAX; i++) {
                if (arr[i][99] == 2) {
                    x = i;
                    break;
                }
            }

            for (int y = MAX - 1; y >= 0; y--) {
                // 왼쪽 확인 후 이동
                if (x != 0 && arr[x - 1][y] == 1) {
                    while (x != 0 && arr[x - 1][y] == 1) {
                        x--;
                    }
                    continue;
                }

                // 오른쪽 확인 후 이동
                if (x != MAX - 1 && arr[x + 1][y] == 1) {
                    while (x != MAX - 1 && arr[x + 1][y] == 1) {
                        x++;
                    }
                }
            }

            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
}
