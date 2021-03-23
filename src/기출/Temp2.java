package src.기출;

import java.io.*;

class Temp2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] input = br.readLine().split("0");
        int[] countArr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            int length = input[i].length() - 1;
            int quotient = length / 2;
            int remainder = length % 2;

            while (quotient > 0) {
                count += combination(quotient+remainder, quotient);
                quotient--;
                remainder += 2;
            }
            count++;
            countArr[i] = count;
        }

        int result = 1;
        for(int i: countArr) {
            result *= i;
        }
        System.out.println(result);
    }

    static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else return combination(n - 1, r - 1) + combination(n - 1, r);
    }

}
