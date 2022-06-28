package programmers.코딩테스트_고득점_Kit.힙Heap;

import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        Solution s = new Solution();
        System.out.println(s.solution(jobs));
    }

    static class Solution {
        public int solution(int[][] jobs) {
            Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));
            PriorityQueue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

            int end = 0;
            int count = 0;
            int time = 0;
            int index = 0;

            while (count < jobs.length) {
                while (index < jobs.length && jobs[index][0] <= end) {
                    que.add(jobs[index++]);
                }

                if (que.isEmpty()) {
                    end = jobs[index][0];
                    continue;
                }

                int[] temp = que.poll();
                time += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }

            return time / jobs.length;
        }
    }

}