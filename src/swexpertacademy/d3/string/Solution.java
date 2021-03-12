package src.swexpertacademy.d3.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d3/string/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            br.readLine();
            String search = br.readLine();
            String string = br.readLine();
            int count = 0;
            int index = 0;
            while(index != -1){
                index = string.indexOf(search);
                if(index == -1) break;
                string = string.substring(index + search.length() - 1);
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
