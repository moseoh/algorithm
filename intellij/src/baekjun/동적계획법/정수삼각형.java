package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수삼각형
 * https://www.acmicpc.net/problem/1932
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-03-31
 */
public class 정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = 1;
            while (st.hasMoreTokens()) {
                triangle[i][k] = Integer.parseInt(st.nextToken());
                k++;
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int k = 1; k <= i; k++) {
                if (k == 1) {
                    triangle[i][1] += triangle[i - 1][1];
                    continue;
                }
                if (k == i) {
                    triangle[i][i] += triangle[i - 1][i - 1];
                    continue;
                }
                triangle[i][k] += Math.max(triangle[i - 1][k - 1], triangle[i - 1][k]);
            }
        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(triangle[N][i], max);
        }

        System.out.println(max);
    }
}
