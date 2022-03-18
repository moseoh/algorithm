package src.개념.stack;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorial(4));
    }
    static int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }
}
