package src.swexpertacademy.d4.괄호짝짓기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/괄호짝짓기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int length = Integer.parseInt(br.readLine());
            String[] string = br.readLine().split("");
            
            sb.append("answer").append("\n");
        }
        System.out.println(sb);
    }
}
