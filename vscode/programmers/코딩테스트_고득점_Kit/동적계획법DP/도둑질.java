package programmers.코딩테스트_고득점_Kit.동적계획법DP;

public class 도둑질 {
    public static void main(String[] args) {
        int[] money = { 1, 2, 3, 1 };
        // int[] money = { 1,4,2,1,6,7,3 };
        Solution s = new Solution();
        System.out.println(s.solution(money));
    }

    static class Solution {
        public int solution(int[] money) {
            int lenght = money.length;
            int[] dpFirst = new int[lenght];
            int[] dpLast = new int[lenght];

            dpFirst[0] = money[0];
            dpFirst[1] = Math.max(money[1], money[0]);

            dpLast[0] = 0;
            dpLast[1] = money[1];

            for (int i = 2; i < lenght; i++) {
                dpLast[i] = Math.max(dpLast[i - 2] + money[i], dpLast[i - 1]);

                if (i == lenght - 1)
                    break;

                dpFirst[i] = Math.max(dpFirst[i - 2] + money[i], dpFirst[i - 1]);
            }

            return Math.max(dpLast[lenght], dpFirst[lenght - 1]);
        }
    }
}