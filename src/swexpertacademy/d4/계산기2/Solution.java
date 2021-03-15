package src.swexpertacademy.d4.계산기2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    // 중위식
    static String[] infixNotation;
    // 후위식
    static StringBuilder postfixNotation;
    // 우선순위
    static HashMap<Character, Integer> operatorPriority = new HashMap<>();

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/계산기2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            br.readLine();
            infixNotation = br.readLine().split("");
            postfixNotation = new StringBuilder();

            setOperatorPriority();
            toPostfixNotation();
            
            sb.append(runCalculatePostfixNotation()).append("\n");
        }
        System.out.println(sb);
    }

    static void setOperatorPriority() {
        operatorPriority.put('(', 0);
        operatorPriority.put(')', 3);
        operatorPriority.put('+', 1);
        operatorPriority.put('-', 1);
        operatorPriority.put('*', 2);
        operatorPriority.put('/', 2);
    }

    static void toPostfixNotation() {
        Stack<Character> stack = new Stack<>();
        // 중위표현식을 후위표현식으로 변환
        for (String s : infixNotation) {
            if (s.matches("[0-9]")) {
                postfixNotation.append(s);
            } else {
                char operator = s.charAt(0);
                // 기존에 있던 연산자보다 새로운 연산자의 우선순위가 낮으면
                while (true) {
                    if (stack.isEmpty()) break;
                    if (operatorPriority.get(stack.peek()) <= operatorPriority.get(operator)) break;
                    postfixNotation.append(stack.pop());
                }
                stack.push(operator);
            }
        }
        while (!stack.isEmpty()) {
            postfixNotation.append(stack.pop());
        }
    }

    static int runCalculatePostfixNotation() {
        Stack<Integer> stack = new Stack<>();
        String[] str = postfixNotation.toString().split("");
        for (int i = 0; i < str.length; i++) {
            if (str[i].matches("[0-9]")) stack.push(Integer.parseInt(str[i]));
            else {
                char op = str[i].charAt(0);
                int x = stack.pop();
                int y = stack.pop();

                switch (op) {
                    case '+':
                        stack.push(x + y);
                        break;
                    case '-':
                        stack.push(x - y);
                        break;
                    case '*':
                        stack.push(x * y);
                        break;
                    case '/':
                        stack.push(x / y);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
