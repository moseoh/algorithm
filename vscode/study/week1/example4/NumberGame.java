package study.week1.example4;

import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        int[] A = { 5, 1, 3, 7 };
        int[] B = { 2, 2, 6, 8 };
        // int[] A = { 2, 2, 2, 2 };
        // int[] B = { 1, 1, 1, 1 };
        Solution s = new Solution();
        System.out.println(s.solution(A, B));
    }

}

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int index = 0, j = 0; j < B.length; j++) {
            if (A[index] < B[j]) {
                answer++;
                index++;
            }
        }

        return answer;
    }
}
