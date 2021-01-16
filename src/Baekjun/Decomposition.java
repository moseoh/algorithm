package src.Baekjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Decomposition {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int sum;
        int temp;
        int digit = 9;
        while (true) {
            if (digit * 10 > num) {
                break;
            }
            digit *= 10;
        }
        for (int i = digit; i < num; i++) {
            sum = 0;
            temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            sum += i;
            if (num == sum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
