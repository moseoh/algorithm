package src.baekjun.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * LCS https://www.acmicpc.net/problem/9251 Github : https://github.com/azqazq195 Created by
 * azqazq195@gmail.com on 2021-04-01
 */
public class LCS {

    static String str1, str2;
    //    static Integer[][] dp;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int k = 1; k <= str2.length(); k++) {
                if (str1.charAt(i - 1) == str2.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
//
//    static int LCS(int x, int y) {
//        if (x == -1 || y == -1)
//            return 0;
//
//        // 만약 탐색하지 않은 인덱스라면?
//        if (dp[x][y] == null) {
//            dp[x][y] = 0;
//
//            // str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
//            if (str1.charAt(x) == str2.charAt(y)) {
//                dp[x][y] = LCS(x - 1, y - 1) + 1;
//            }
//
//            // 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
//            else {
//                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
//            }
//        }
//
//        return dp[x][y];
//    }
}
