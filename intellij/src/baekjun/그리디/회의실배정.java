package src.baekjun.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 회의실배정
 * https://www.acmicpc.net/problem/1931
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-25
 */
public class 회의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(temp[0]);
            time[i][1] = Integer.parseInt(temp[1]);
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int temp = 0;
        for(int i =0; i< N; i++) {
            if(temp <= time[i][0]) {
                temp = time[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}
