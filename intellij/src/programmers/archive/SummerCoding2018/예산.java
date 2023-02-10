package src.programmers.archive.SummerCoding2018;

import java.util.Arrays;

/**
 * 예산
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-22
 */
public class 예산 {
    public static void main(String[] args) {
//        int[] d = {1, 3, 2, 5, 4};
//        int budget = 9;

        int[] d = {2, 2, 3, 3};
        int budget = 10;

        System.out.println(new Solution().solution(d, budget));
    }

    static class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            int sum = 0;
            Arrays.sort(d);

            for (int i = 0; i < d.length; i++) {
                sum += d[i];
                if (sum > budget) break;
                answer++;
            }

            return answer;
        }
    }
}
