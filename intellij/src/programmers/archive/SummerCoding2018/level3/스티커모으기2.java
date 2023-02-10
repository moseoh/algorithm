package src.programmers.archive.SummerCoding2018.level3;

/**
 * 스티커모으기2
 * https://programmers.co.kr/learn/courses/30/lessons/12971
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-07
 */
public class 스티커모으기2 {
    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        // 36
        System.out.println(new Solution().solution(sticker));
    }

    static class Solution {
        public int solution(int sticker[]) {
            int length = sticker.length;

            int[] dp1 = new int[length];
            int[] dp2 = new int[length];

            if (length == 1)
                return sticker[0];
            if (length == 2)
                return Math.max(sticker[0], sticker[1]);

            dp1[0] = sticker[0];
            dp1[1] = sticker[0];

            dp2[0] = 0;
            dp2[1] = sticker[1];

            for (int i = 2; i < length - 1; i++) {
                dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
                dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
            }

            int i = length - 1;
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);

            return Math.max(dp1[i], dp2[i]);
        }

    }
}
