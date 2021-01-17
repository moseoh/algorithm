package src.Baekjun.브루트_포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 빅맨 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int[][] men = new int[num][2];
        int[] ranks = new int[num];

        for (int i = 0; i < num; i++) {
            String str[] = br.readLine().split(" ");
            men[i][0] = Integer.parseInt(str[0]);
            men[i][1] = Integer.parseInt(str[1]);
        }

        for (int i = 0; i < num; i++) {
            int rank = 1;
            for (int j = 0; j < num; j++) {
                if (i == j)
                    continue;
                if (men[i][0] < men[j][0] && men[i][1] < men[j][1])
                    rank++;
            }
            ranks[i] = rank;
        }

        for (int i : ranks) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
