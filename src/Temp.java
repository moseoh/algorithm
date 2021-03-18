package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp {
    public static void main(String[] args) throws Exception {
        // n, k, 배열
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int length = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = Integer.parseInt(input2[i]);
        }

        int min = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if(i == 0) {
                min = num[i];
                index = i;
                continue;
            }
            if(min > num[i]) {
                min = num[i];
                index = i;
            }
        }

        int result = 0;
        for(int i = index; i > index - k; i--){
//            System.out.println("index: " + i);
            if(i < 0) break;
            int count = 0;
            int temp = i;
            while(temp > 0){
                temp -= (k-1);
                count++;
//                System.out.print("왼 ");
            }

            temp = i;
            while(temp < length - 1){
                temp += (k-1);
                count++;
//                System.out.print("오 ");
            }
//            System.out.println("count: " + count);
            if(i == index) result = count;
            if(result > count) result = count;
        }

//        for (int i : num) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        System.out.println("min: " + min);
//        System.out.println("index: " + index);
//        System.out.println("result: " + result);
        System.out.println(result);
    }
}
