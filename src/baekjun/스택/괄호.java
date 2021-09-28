package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            Stack<Boolean> stack = new Stack<>();
            String line = br.readLine();
            if(sb.length() != 0) sb.append("\n");

            boolean isVPS = true;
            for(int i = 0 ; i < line.length(); i++) {
                if(line.charAt(i) == '(') {
                    stack.push(true);
                    continue;
                }

                if(line.charAt(i) == ')') {
                    if(stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && isVPS) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
        }

        System.out.println(sb.toString());
    }
}
