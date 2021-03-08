package src.concept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그리디 {
    public static void main(String[] args) throws IOException {
        babyGin();
    }

    public static void babyGin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("");
        int[] countArray = new int[10];

        // 입력받은 숫자를 정수형 배열에 추가
        for (String number : numbers) {
            countArray[Integer.parseInt(number)]++;
        }

        // run 혹은 triplete 구분
        // run
        for (int i = 0; i < countArray.length-2;) {
            if (
                    countArray[i] != 0 &&
                            countArray[i + 1] != 0 &&
                            countArray[i + 2] != 0
            ) {
                countArray[i]--;
                countArray[i+1]--;
                countArray[i+2]--;
                System.out.println("run: " + i);
            } else {
                i++;
            }
        }

        for(int i=0; i< countArray.length;){
            if(countArray[i]>=3) {
                countArray[i] -= 3;
                System.out.println("triplete: " + i);
            } else {
                i++;
            }
        }

        boolean result = true;
        for (int i : countArray) {
            if (i != 0) {
                result = false;
                break;
            }
        }

        System.out.println(result);

    }

    public static void exchange() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        // 잔돈은 100, 500, 1000, 10000, 50000
        int[] exchange = {50000, 10000, 1000, 500, 100};
        int[] counts = new int[5];

        int temp = 0;
        int i = 0;
        if (money % 100 == 0) {
            while (true) {
                temp += exchange[i];
                if (money < temp) {
                    temp -= exchange[i++];
                } else {
                    counts[i]++;
                }
                if (money == temp) break;
            }
            for (int j = 0; j < exchange.length; j++) {
                System.out.println(exchange[j] + ": " + counts[j]);
            }
        } else {
            System.out.println("계산 불가");
        }
    }
}
