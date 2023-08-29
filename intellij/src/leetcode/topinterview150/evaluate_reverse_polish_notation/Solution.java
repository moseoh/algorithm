package src.leetcode.topinterview150.evaluate_reverse_polish_notation;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        String[] token = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(new Solution().evalRPN(token));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                stack.push(calc(stack, token));
                stack.add(1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public int calc(Stack<Integer> stack, String op) {
        int b = stack.pop();
        int a = stack.pop();

        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new RuntimeException("not support operation: " + op);
        };
    }
}