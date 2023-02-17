package src.programmers.archive.etc.Level2.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;

        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            count++;
            if (sum1 > sum2) {
                sum1 -= que1.peek();
                sum2 += que1.peek();
                que2.add(que1.poll());
            } else {
                sum1 += que2.peek();
                sum2 -= que2.peek();
                que1.add(que2.poll());
            }
            if (count > 600001) {
                return -1;
            }
        }

        return count;
    }
}