package programmers.코딩테스트_고득점_Kit.탐욕법Greedy;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = { 240, 240, 240, 240, 239, 40, 40 };
        int limit = 240;
        Solution s = new Solution();
        System.out.println(s.solution(people, limit));
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);

            int answer = 0;
            int index = people.length - 1;
            for (int i = 0; i <= index; i++, answer++)
                while (index > i && people[i] + people[index--] > limit)
                    answer++;

            return answer;
        }
    }
}
