package src.baekjun.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소인수분해 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num != 1) {
            factorization(num);
        }
    }

    static void factorization(int num) {
        int temp = 2;
        StringBuilder sb = new StringBuilder();
        while (num != 1) {
            System.out.println(temp);
            if (num % temp == 0) {
                sb.append(temp).append("\n");
                num /= temp;
            } else {
                temp++;
            }
        }
        System.out.println(sb);
    }
}
