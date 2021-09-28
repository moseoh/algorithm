package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택_수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        boolean isEnd = false;

        while (true) {
            int num = Integer.parseInt(br.readLine());

            while (!isEnd) {
                if (!stack.isEmpty())
                    if (stack.peek() == num)
                        break;

                stack.push(index++);
                sb.append("+\n");
                if(index > n) isEnd = true;
            }

            if(stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
                if(isEnd && stack.isEmpty()) break;
            } else {
                if(isEnd && !stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
