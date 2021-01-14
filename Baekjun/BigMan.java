package Baekjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigMan {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int mans[][] = new int[num][2];
        int ranks[] = new int[num];

        for (int i = 0; i < num; i++) {
            String str[] = br.readLine().split(" ");
            mans[i][0] = Integer.parseInt(str[0]);
            mans[i][1] = Integer.parseInt(str[1]);
        }

        for (int i = 0; i < num; i++) {
            int rank = 1;
            for (int j = 0; j < num; j++) {
                if (i == j)
                    continue;
                if (mans[i][0] < mans[j][0] && mans[i][1] < mans[j][1])
                    rank++;
            }
            ranks[i] = rank;
        }

        for (int i : ranks) {
            System.out.print(i + " ");
        }
    }
}
