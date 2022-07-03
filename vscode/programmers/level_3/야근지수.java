package programmers.level_3;

import java.util.PriorityQueue;

public class 야근지수 {
    public static void main(String[] args) {
        // int[] works = { 4, 3, 3 };
        // int n = 4;
        // int[] works = { 2, 1, 2 };
        // int n = 1;
        int[] works = { 5, 2, 6, 1, 9 };
        int n = 10;

        Solution s = new Solution();
        System.out.println(s.solution(n, works));
    }

    static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> (b - a));
            for (int work : works) {
                que.add(work);
            }

            while (!que.isEmpty() && n > 0) {
                int num = que.poll();
                que.add(num - 1);
                n--;
            }

            for (Integer num : que) {
                answer += pow(num);
            }

            return answer;
        }

        public long pow(int num) {
            if (num <= 0) {
                return 0;
            }

            return (long) Math.pow(num, 2);
        }
    }

}
