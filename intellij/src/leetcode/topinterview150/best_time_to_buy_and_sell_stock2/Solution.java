package src.leetcode.topinterview150.best_time_to_buy_and_sell_stock2;

class Solution {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 3};

        int result = new Solution().maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}