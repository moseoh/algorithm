package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌_세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.length() == 1 && line.charAt(0) == '.') break;
            if (sb.length() != 0) sb.append("\n");

            Stack<Character> stack = new Stack<>();
            boolean isBalance = true;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(') {
                    stack.push(c);
                    continue;
                }

                if (c == ')') {
                    if (stack.isEmpty()) {
                        isBalance = false;
                        break;
                    }

                    if (stack.peek() != '(') {
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                    continue;
                }

                if (c == '[') {
                    stack.push(c);
                    continue;
                }

                if (c == ']') {
                    if (stack.isEmpty()) {
                        isBalance = false;
                        break;
                    }

                    if (stack.peek() != '[') {
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (isBalance && stack.isEmpty()) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
        }

        System.out.println(sb.toString());
    }
}
