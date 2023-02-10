package src.programmers.Level2.짝지어제거하기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s1 = "baabaa";
        String s2 = "cdcd";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
