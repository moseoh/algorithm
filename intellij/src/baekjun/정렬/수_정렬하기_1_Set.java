package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 수_정렬하기_1_Set {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        for (Integer integer : set) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
    }
}