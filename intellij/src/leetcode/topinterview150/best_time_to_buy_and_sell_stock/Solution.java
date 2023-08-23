package src.leetcode.topinterview150.best_time_to_buy_and_sell_stock;

class Solution {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        new Solution().maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int price : prices) {
            if (min > price) {
                min = price;
            } else {
                result = Math.max(result, price - min);
            }
        }

        System.out.println(result);

        return result;
    }
}