package src.개념.stack;

import java.util.ArrayList;

public class ListStack {
    static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) {
        int item;

        push(1);
        push(2);
        push(3);

        pop();
        pop();
        pop();
        pop();
    }

    static void push(int item) {
        stack.add(item);
        System.out.println("push item => " + item);
    }

    static void pop() {
        if (stack.size() == 0) {
            System.out.println("스택 is Empty!!");
        } else {
            int item = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            System.out.println("pop item => " + item);
        }
    }

}
