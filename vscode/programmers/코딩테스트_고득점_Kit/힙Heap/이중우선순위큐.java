package programmers.코딩테스트_고득점_Kit.힙Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(operations)));
    }

    static class Solution {
        PriorityQueue<Integer> maxQue;
        PriorityQueue<Integer> minQue;

        public int[] solution(String[] operations) {
            maxQue = new PriorityQueue<>((a, b) -> (b - a));
            minQue = new PriorityQueue<>((a, b) -> (a - b));

            for (String operation : operations) {
                calc(operation);
            }

            if (maxQue.isEmpty()) {
                return new int[] { 0, 0 };
            }

            return new int[] { maxQue.poll(), minQue.poll() };
        }

        public void calc(String operation) {
            if (operation.startsWith("I")) {
                add(Integer.parseInt(operation.split(" ")[1]));
                return;
            }

            if (operation.equals("D 1")) {
                removeMax();
                return;
            }

            removeMin();
        }

        public void add(int num) {
            maxQue.add(num);
            minQue.add(num);
        }

        public void removeMax() {
            if (maxQue.isEmpty()) {
                return;
            }
            minQue.remove(maxQue.poll());
        }

        public void removeMin() {
            if (maxQue.isEmpty()) {
                return;
            }
            maxQue.remove(minQue.poll());
        }
    }
}
