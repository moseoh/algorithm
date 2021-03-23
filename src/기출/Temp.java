package src.기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Temp {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Date min = format.parse("00:00");
        Date max = format.parse("23:59");
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            Date d1 = format.parse(input[0]);
            Date d2 = format.parse(input[2]);
            if (d1.after(min)) min = d1;
            if (d2.before(max)) max = d2;
        }
        if (max.after(min)) System.out.println(format.format(min) + " ~ " + format.format(max));
        else System.out.println(-1);
    }
}
