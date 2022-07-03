package programmers.코딩테스트_고득점_Kit.이분탐색;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        // int[] times = { 7, 10 }; // 28
        int[] times = { 7, 9 }; // 27
        Solution s = new Solution();
        System.out.println(s.solution(n, times));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);

            long start = times[0];
            long end = (long) n * times[times.length - 1];

            long answer = 0;
            long mid, sum;
            while (start <= end) {
                mid = (end + start) / 2;
                sum = 0;

                for (int time : times) {
                    sum += mid / time;
                }

                if (sum >= n) {
                    end = mid - 1;
                    answer = mid;
                } else {
                    start = mid + 1;
                }
            }

            return answer;
        }
    }
}
