package test.skt.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.IntStream;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) {
        int[] cost = { 2, 11, 20, 100, 200, 600 };
        int money = 1999;

        Solution solution = new Solution();

        System.out.println(solution.solution(money, cost));
    }

    static class Solution {
        private static final int[] COINS = { 1, 5, 10, 50, 100, 500 };

        public int solution(int money, int[] costs) {
            if (money < 0 || costs == null || costs.length != COINS.length) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            return calculateMinimumCost(money, createSortedCoinInfoList(costs));
        }

        private List<CoinInfo> createSortedCoinInfoList(int[] costs) {
            return IntStream.range(0, costs.length)
                    .mapToObj(i -> new CoinInfo(COINS[i], costs[i]))
                    .sorted(Comparator.comparingDouble(CoinInfo::getCostEfficiency))
                    .collect(Collectors.toList());
        }

        private int calculateMinimumCost(int money, List<CoinInfo> coinInfoList) {
            return coinInfoList.stream()
                    .mapToInt(coinInfo -> {
                        int quotient = money / coinInfo.value;
                        money %= coinInfo.value;
                        return quotient * coinInfo.cost;
                    })
                    .sum();
        }

        // ... CoinInfo 클래스는 그대로 유지 ...
    }

    static class CoinInfo {
        private final int value;
        private final int cost;

        public CoinInfo(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        public double getCostEfficiency() {
            return (double) cost / value;
        }
    }
}
