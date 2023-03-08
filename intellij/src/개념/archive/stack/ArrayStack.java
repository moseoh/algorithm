package src.개념.archive.stack;

public class ArrayStack {
    static int[] stack = new int[100];
    static int top = -1;

    public static void main(String[] args) {
        int item;

        push(1);
        push(2);
        push(3);

        item = pop();
        System.out.println("pop item => " + item);
        item = pop();
        System.out.println("pop item => " + item);
        item = pop();
        System.out.println("pop item => " + item);
    }

    static void push(int item) {
        if (top < 99) {
            stack[++top] = item;
        }
    }

    static int pop() {
        if (top == -1) {
            System.out.println("스택 is Empty!!");
            return 0;
        } else return stack[top--];
    }
}
