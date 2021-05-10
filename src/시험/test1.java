package src.시험;

import java.util.Arrays;
import java.util.Collections;

/**
 * test1
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-08
 */
public class test1 {
    public static void main(String[] args) {
        int[] weights = {50, 82, 75, 120};
        String[] head2head = {"NLWL", "WNLL", "LWNW", "WWLN"};
        System.out.println(Arrays.toString(new Solution().solution(weights, head2head)));
    }

    static class Head implements Comparable<Head> {
        int index;
        int weights;
        float rate;
        int count;

        Head(int index, int weights, float rate, int count) {
            this.index = index;
            this.weights = weights;
            this.rate = rate;
            this.count = count;
        }

        @Override
        public int compareTo(Head o) {
            if (this.rate > o.rate) return -1;
            if (this.rate < o.rate) return 1;
            if (this.count > o.count) return -1;
            if (this.count < o.count) return 1;
            if (this.weights > o.weights) return -1;
            if (this.weights < o.weights) return 1;
            if (this.index > o.index) return 1;
            return -1;
        }
    }

    static class Solution {
        public int[] solution(int[] weights, String[] head2head) {

            int size = weights.length;
            int[] answer = new int[size];
            Head[] head = new Head[size];

            for (int i = 0; i < size; i++) {
                int win = 0;
                int lose = 0;
                float rate = 0;
                int count = 0;
                for (int k = 0; k < size; k++) {
                    char temp = head2head[i].charAt(k);
                    if (temp == 'L') {
                        lose++;
                    } else if (temp == 'W') {
                        win++;
                        if (weights[i] < weights[k]) count++;
                    }
                }
                if (win + lose == 0) rate = 0;
                else rate = (float) win * 100 / (win + lose);
                head[i] = new Head(i + 1, weights[i], rate, count);
            }

            Arrays.sort(head);

            for (int i = 0; i < size; i++)
                answer[i] = head[i].index;

            return answer;
        }
    }
}
