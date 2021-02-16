package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수_정렬하기_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int range = 2000001;

        boolean[] num = new boolean[range];

        for (int i = 0; i < N; i++) {
            num[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for (int i = 0; i < range; i++) {
            if(num[i]) sb.append(i - 1000000).append("\n");
        }

        System.out.println(sb);
    }
}
