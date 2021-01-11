package Baekjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigNumAB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        // String answer = "";
        StringBuilder sb = new StringBuilder();

        int maxLength = str[0].length() > str[1].length() ? str[0].length() : str[1].length();
        maxLength += 1;
        int num[][] = new int[2][maxLength];

        for (int k = 0; k < 2; k++) {
            int a = 0;
            for (int i = str[k].length() - 1; i >= 0; i--) {
                num[k][a] = Character.getNumericValue(str[k].charAt(i));
                a++;
            }
        }

        for (int i = 0; i < maxLength; i++) {
            num[0][i] = num[0][i] + num[1][i];
        }

        for (int i = 0; i < maxLength; i++) {
            if (num[0][i] >= 10) {
                num[0][i] -= 10;
                num[0][i + 1] += 1;
            }
        }

        for (int i = maxLength - 1; i >= 0; i--) {
            if (num[0][i] == 0)
                continue;
            else {
                for (int k = i; k >= 0; k--) {
                    // answer = answer + String.valueOf(num[0][k]);
                    sb.append(String.valueOf(num[0][k]));
                }
                break;
            }
        }

        System.out.println(sb);
    }
}
