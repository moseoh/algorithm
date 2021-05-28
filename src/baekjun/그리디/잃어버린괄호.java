package src.baekjun.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 잃어버린괄호
 * https://www.acmicpc.net/problem/1541
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-27
 */
public class 잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp = br.readLine();

        String[] num = temp.split("[^0-9]");
        String[] op = temp.split("[0-9]+");

        int result = 0;
        boolean minus = false;

        for (int i = 0; i < num.length; i++) {
            if(minus)
                result -= Integer.parseInt(num[i]);
            else
                result += Integer.parseInt(num[i]);

            if (i+1 <num.length && op[i+1].equals("-")) minus = true;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
