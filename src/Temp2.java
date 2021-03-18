package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] temp = br.readLine().split(" ");
            Long n = Long.parseLong(temp[0]);
            Long k = Long.parseLong(temp[1]);

            int count = 0;

            int x = (int) (n / 5L);
            int y = (int) (k / 7L);

            if (x != 0 && y != 0) {
                if (x > y) count = y;
                else count = x;

                n -= count * 5L;
                count += n / 12L;

            } else if (y == 0) {
                count = (int) (n / 12L);
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
