package src.기출.num2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Temp2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] temp = br.readLine().split(" ");
//            Long n = Long.parseLong(temp[0]);
//            Long k = Long.parseLong(temp[1]);
//
//            int count = 0;
//
//            int x = (int) (n / 5L);
//            int y = (int) (k / 7L);
//
//            if (x != 0 && y != 0) {
//                if (x > y) count = y;
//                else count = x;
//
//                n -= count * 5L;
//                count += n / 12L;
//
//            } else if (y == 0) {
//                count = (int) (n / 12L);
//            }
//
//            sb.append(count).append("\n");

            long num1 = 0, num2 = 0;
            long result=0, result1= 0, result2=0;

            // 값 1 , 값 2 만들기 N과 K의 값
            // 한정 음료의 갯수
            num1 = Long.parseLong(temp[0]);

            // num2 : 쿠폰의 갯수
            num2 = Long.parseLong(temp[1]);

            result1 = num1/5;
            result2 = (num1+num2)/12;

            result = (result1 <= result2)? result1 : result2;

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
