package src.baekjun.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTop {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, num) - 1)).append('\n');
        hanoi(num, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int num, int start, int mid, int to) {
        if (num == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoi(num - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        hanoi(num - 1, mid, start, to);

    }
}
