package programmers.코딩테스트_고득점_Kit.탐욕법Greedy;

import java.util.Arrays;

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
        Solution s = new Solution();
        System.out.println(s.solution(routes));
    }

    static class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes, (a, b) -> (a[1] - b[1]));

            int answer = 1;
            int end = routes[0][1];

            for (int[] route : routes) {
                if (end < route[0]) {
                    end = route[1];
                    answer++;
                }
            }

            return answer;
        }
    }
}
