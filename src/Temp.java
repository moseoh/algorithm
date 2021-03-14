package src;

import java.util.Stack;

public class Temp {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.pop());
        try {
            System.out.println(stack.pop());
        } catch (Exception e){
            System.out.println("에러");
        }
        
    }
}
