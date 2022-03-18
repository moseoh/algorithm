package src.baekjun.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 신나는함수실행
 * https://www.acmicpc.net/problem/9184
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-03-31
 */
public class 신나는함수실행 {
    static int[][][] ans = new int[21][21][21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            sb.append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if(inRange(a, b, c) && ans[a][b][c] != 0)return ans[a][b][c];
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return ans[20][20][20] = w(20,20,20);
        if (a < b && b < c) return ans[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        return ans[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) -w(a-1,b-1,c-1);
    }
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
