package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 나이순정렬 {
    static class Info implements Comparable<Info> {
        int age;
        String name;

        @Override
        public int compareTo(Info o) {
                return this.age - o.age;
        }

        public Info(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Info[] infos = new Info[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            infos[i] = new Info(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(infos);

        for (int i = 0; i < N; i++) {
            System.out.println(infos[i].age + " " + infos[i].name);
        }
    }
}

