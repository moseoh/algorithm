package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 소트인사이드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] intArray = new Integer[str.length()];
        for(int i = 0 ; i < str.length(); i++) {
            intArray[i] = str.charAt(i) - '0';
        }
        Arrays.sort(intArray, Collections.reverseOrder());

        for(int c : intArray)
            System.out.print(c);
    }
}
