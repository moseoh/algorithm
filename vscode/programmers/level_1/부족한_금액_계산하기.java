package programmers.level_1;

public class 부족한_금액_계산하기 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        System.out.println(new Solution().solution(price, money, count));
    }

    static class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0;

            for (int i = 1; i <= count; i++) {
                answer += i;
            }

            answer = answer * price - money;
            return answer < 0 ? 0 : answer;
        }
    }
}
