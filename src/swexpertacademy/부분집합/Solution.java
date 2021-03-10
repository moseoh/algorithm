package src.swexpertacademy.부분집합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/부분집합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 2; test_case++) {
            System.out.println("#" + test_case);
            br.readLine();
            String[] temp = br.readLine().split(" ");
            int[] num = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                num[i] = Integer.parseInt(temp[i]);
            }

            boolean[][] bit = new boolean[1 << num.length][num.length];
            int index = 0;
            for (int j = 1; j < 1 << num.length; j *= 2) {
                for (int i = 0; i < 1 << num.length; i++) {
                    if ((i / j) % 2 == 1) {
                        bit[i][index] = true;
                    }
                }
                index++;
            }

            for (boolean[] booleans : bit) {
                int result = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < booleans.length; j++) {
                    if (booleans[j]) {
                        result += num[j];
                        sb.append(num[j]).append("\t");
                    }
                }
                if (result == 0) System.out.println("result: " + sb);
            }
            System.out.println();
        }
    }
}
