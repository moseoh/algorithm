package src.swexpertacademy.문제.flatten;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/문제/flatten/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int[] num = new int[101];
            int count = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            for (String s : temp) {
                num[Integer.parseInt(s)]++;
            }

            while (count-- > 0) {
                for (int i = num.length - 1; i >= 1; i--) {
                    if (num[i] > 0) {
                        num[i]--;
                        num[i-1]++;
                        break;
                    }
                }
                for (int i = 1; i < num.length; i++) {
                    if (num[i] > 0) {
                        num[i+1]++;
                        num[i]--;
                        break;
                    }
                }
            }

            int min = 0;
            int max = 0;
            for (int i = 1; i < num.length; i++) {
                if (num[i] > 0) {
                    min = i;
                    break;
                }
            }
            for (int i = num.length - 1; i >= 1; i--) {
                if (num[i] > 0) {
                    max = i;
                    break;
                }
            }
            int result = max - min;
            System.out.println("#"+ test_case + " " + result);
        }
    }
}
