package programmers.level_3;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = { 7, 10 };
        Solution s = new Solution();
        System.out.println(s.solution(n, times));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            long start = times[0];
            long end = (long) n * times[times.length - 1];
            long sum;
            long mid;

            while (start <= end) {
                sum = 0;
                mid = (start + end) / 2;
                for (int time : times) {
                    sum += (mid / time);
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
