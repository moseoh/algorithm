package src.swexpertacademy.문제.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/문제/view/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0 0 5 4 7 8 2 0 0
        // 0 0 0 0 0 1 0 0 0
        for (int test_case = 1; test_case <= 10; test_case++) {
            int[] building = new int[Integer.parseInt(br.readLine())];
            String[] temp = br.readLine().split(" ");
            int result = 0;

            for (int i = 0; i < building.length; i++) {
                building[i] = Integer.parseInt(temp[i]);
            }

            for (int i = 2; i < building.length - 2; i++) {
                int max = 0;
                if(building[i-2] > max) max = building[i-2];
                if(building[i-1] > max) max = building[i-1];
                if(building[i+1] > max) max = building[i+1];
                if(building[i+2] > max) max = building[i+2];
                if(building[i] > max) result = result + building[i] - max;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}