package programmers.코딩테스트_고득점_Kit.완전탐색;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    public static void main(String[] args) {
        String numbers = "011";
        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }

    static class Solution {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[7];

        int answer = 0;

        public int solution(String numbers) {
            for (int i = 0; i < numbers.length(); i++) {
                getNums(numbers, "", i + 1);
            }

            System.out.println(set);

            for (Integer n : set) {
                isPrime(n);
            }

            return answer;
        }

        public void getNums(String numbers, String tmp, int digits) {
            if (digits == tmp.length()) {
                set.add(Integer.parseInt(tmp));
                return;
            }

            for (int i = 0; i < numbers.length(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    tmp += numbers.charAt(i);
                    getNums(numbers, tmp, digits);
                    visited[i] = false;
                    tmp = tmp.substring(0, tmp.length() - 1);
                }
            }

        }

        public void isPrime(int n) {
            if (n == 0)
                return;
            if (n == 1)
                return;
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0)
                    return;
            }
            answer++;
        }
    }
}
