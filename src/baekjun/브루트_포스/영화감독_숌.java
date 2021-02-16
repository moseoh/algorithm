package src.baekjun.브루트_포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 영화감독_숌 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 665;

        while (N > count) {
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);
    }
}
