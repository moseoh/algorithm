package src.codility.kakomoblity.test1;

public class Solution {
    public static void main(String[] args) {
        int N = 45506;
        solution(N);
    }

    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 == 0) {
                return;
            } else {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
}

