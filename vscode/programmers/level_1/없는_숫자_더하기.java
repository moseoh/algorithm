package programmers.level_1;

import java.util.*;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < numbers.length; i++) {
                set.add(numbers[i]);
            }

            for (int i = 0; i < 10; i++) {
                if (!set.contains(i)) {
                    answer += i;
                }
            }

            return answer;
        }
    }
}
