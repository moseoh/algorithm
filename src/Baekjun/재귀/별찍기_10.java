package src.Baekjun.재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 별찍기_10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        char star[][] = new char[num][num];

        for (int i = 0; i < num; i++) {
            Arrays.fill(star[i], '*');
        }

        drawStar(star, num, num);

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static char[][] drawStar(char star[][], int num, int size) {
        int temp = num;
        temp = temp / 3;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i % num) / temp == 1 && (j % num) / temp == 1)
                    star[i][j] = ' ';
            }
        }
        num = num / 3;
        if (num != 1) {
            return drawStar(star, num, size);
        } else {
            return star;
        }
    }
}
