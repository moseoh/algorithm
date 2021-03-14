package src.swexpertacademy.d4.괄호짝짓기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/괄호짝짓기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int length = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split("");
            Stack<Integer>[] stacks = new Stack[4];
            for (int i = 0; i < 4; i++) {
                // 0 = ()
                // 1 = []
                // 2 = {}
                // 3 = <>
                stacks[i] = new Stack<>();
            }
            String[][] inputs = {{"(", ")"}, {"[", "]"}, {"{", "}"}, {"<", ">"}};

            // true = 1, false = 0
            int result = 1;

            for (String string : strings) {
                for (int i = 0; i < inputs.length; i++) {
                    if (string.equals(inputs[i][0])) {
                        stacks[i].push(1);
                        break;
                    }
                }

                for (int i = 0; i < inputs.length; i++) {
                    if (string.equals(inputs[i][1])) {
                        try {
                            stacks[i].pop();
                        } catch (Exception e) {
                            result = 0;
                        }
                    }
                }
            }

            for (Stack<Integer> stack : stacks) {
                if (stack.size() != 0) {
                    result = 0;
                    break;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
