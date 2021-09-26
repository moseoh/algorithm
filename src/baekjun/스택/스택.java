package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        while (num-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(stack.pop());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case "top":
                    if (stack.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(stack.peek());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
