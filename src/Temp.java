package src;

import src.baekjun.기본수학1.큰수AB;

import java.util.*;

class Temp {
    static class Solution {
        public int solution(int[] prices, int[] discounts) {
            int answer = 0;

            Integer[] pricesArr = Arrays.stream(prices).boxed().toArray(Integer[]::new);
            Integer[] discountArr = Arrays.stream(discounts).boxed().toArray(Integer[]::new);

            Arrays.sort(pricesArr, Collections.reverseOrder());
            Arrays.sort(discountArr, Collections.reverseOrder());

            for (int i = 0; i < pricesArr.length; i++) {
                if(i >= discountArr.length) break;
                pricesArr[i] = discount(pricesArr[i], discountArr[i]);
            }

            for(Integer price : pricesArr) answer += price;

            return answer;
        }

        public int discount(int price, int discount) {
            return price * (100 - discount) / 100;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20};
        System.out.println(solution.solution(prices, discounts));
    }
}
