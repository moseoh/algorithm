package src.swexpertacademy.d3.거듭제곱;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d3/거듭제곱/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            br.readLine();
            String[] temp = br.readLine().split(" ");
            int num = Integer.parseInt(temp[0]);
            int power = Integer.parseInt(temp[1]);
            sb.append(power(num, power)).append("\n");
        }
        System.out.println(sb);
    }
    static int power(int num, int power){
        if(power == 0) return 1;
        return num * power(num, power - 1);
    }
}
