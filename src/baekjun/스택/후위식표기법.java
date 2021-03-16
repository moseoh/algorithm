package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class 후위식표기법 {
    static HashMap<Character, Integer> isp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] infix = br.readLine().toCharArray();
        setPrecedence();
        System.out.println(replacePostfix(infix));
    }

    static void setPrecedence() {
        // in-stack precedence, incoming precedence
        isp = new HashMap<>();

        isp.put('*', 1);
        isp.put('/', 1);
        isp.put('+', 2);
        isp.put('-', 2);
        isp.put('(', 3);
    }

    static StringBuilder replacePostfix(char[] infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (Character ch : infix) {
            // 피연산자
            if (ch >= 'A' && ch <= 'Z') {
                postfix.append(ch);
                continue;
            }
            // 연산자가 없을 경우
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            // 들어오는 연산자가 기존의 연산자보다 우선순위가 높을 경우
            if (isp.get(ch) < isp.get(stack.peek())) {
                stack.push(ch);
                continue;
            }
            // 들어오는 연산자가 기존의 연산자보다 우선순위가 낮거나 같은 경우
            if (isp.get(ch) >= isp.get(stack.peek())) {
                while (true) {
                    if(stack.isEmpty()) break;
                    if (isp.get(ch) < isp.get(stack.peek())) break;
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) postfix.append(stack.pop());

        return postfix;
    }
}
