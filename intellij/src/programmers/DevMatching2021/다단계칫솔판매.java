package src.programmers.DevMatching2021;

import java.util.*;

/**
 * 다단계칫솔판매
 * https://programmers.co.kr/learn/courses/30/lessons/77486
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-27
 */
public class 다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(new Solution().solution(enroll, referral, seller, amount)));
    }

    static class Solution {
        static Map<String, String> referralMap;
        static Map<String, Integer> profitMap;

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            referralMap = new HashMap<>();
            profitMap = new HashMap<>();

            for (int i = 0; i < enroll.length; i++)
                referralMap.put(enroll[i], referral[i]);

            for (int i = 0; i < seller.length; i++)
                calculateProfit(seller[i], amount[i] * 100);

            for (int i = 0; i < answer.length; i++)
                answer[i] = profitMap.getOrDefault(enroll[i], 0);

            return answer;
        }

        static void calculateProfit(String enroll, int price) {
            int profit = price;
            int divide = profit / 10;
            profit -= divide;

            profit += profitMap.getOrDefault(enroll, 0);
            profitMap.put(enroll, profit);

            if (referralMap.get(enroll).equals("-")) return;

            calculateProfit(referralMap.get(enroll), divide);
        }
    }
}
