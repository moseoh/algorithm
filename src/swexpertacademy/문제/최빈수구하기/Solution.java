package src.swexpertacademy.문제.최빈수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/문제/최빈수구하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.print("#" + br.readLine() + " ");
            // 숫자 담기
            String[] temp = br.readLine().split(" ");
            // 카운트할 배열 0~100
            int[] count = new int[101];
            for (String s : temp) {
                count[Integer.parseInt(s)]++;
            }
            // 가장 큰수 찾기
            int max = 0;
            int index = 0;
            for (int i = 0; i < count.length; i++) {
                if (max <= count[i]) {
                    max = count[i];
                    index = i;
                }
            }
            System.out.println(index);
        }
    }
}