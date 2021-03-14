package src.swexpertacademy.d3.회문1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d3/회문1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            // 회문 길이와 문자열 받기
            int length = Integer.parseInt(br.readLine());
            String[][] string = new String[8][8];
            for (int i = 0; i < string.length; i++) {
                string[i] = br.readLine().split("");
            }

            int count = 0;
            // 행의 회문 검사
            for (int i = 0; i < string.length; i++) {
                for (int j = 0; j <= string.length - length; j++) {
                    boolean result = true;
                    for (int k = j; k < j + length / 2; k++) {
                        if (!string[i][k].equals(string[i][length - k - 1 + 2*j])) {
                            result = false;
                            break;
                        }
                    }
                    if (result) {
                        count++;
                    }
                }
            }

            // 열의 회문 검사
            for (int i = 0; i < string.length; i++) {
                for (int j = 0; j <= string.length - length; j++) {
                    boolean result = true;
                    for (int k = j; k < j + length / 2; k++) {
                        if (!string[k][i].equals(string[length - k - 1 + 2*j][i])) {
                            result = false;
                            break;
                        }
                    }
                    if (result) count++;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
