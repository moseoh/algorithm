package src.baekjun.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 주유소
 * https://www.acmicpc.net/problem/13305
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-27
 */
public class 주유소 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer dist, gas;

        br.readLine();
        dist = new StringTokenizer(br.readLine());
        gas = new StringTokenizer(br.readLine());

        long min = Integer.MAX_VALUE;
        long result = 0;

        while(dist.hasMoreTokens()) {
            min = Math.min(min, Integer.parseInt(gas.nextToken()));
            result += min * Integer.parseInt(dist.nextToken());
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }
}
