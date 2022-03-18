package src.programmers.SummerCoding2018.level3;

import java.util.Arrays;

/**
 * 숫자게임
 * https://programmers.co.kr/learn/courses/30/lessons/12987
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-07
 */
public class 숫자게임 {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        System.out.println(new Solution().solution(A, B));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            int aIndex = 0;
            int bIndex = 0;

            while(bIndex < A.length){
                if (A[aIndex] >= B[bIndex]) {
                    bIndex++;
                    continue;
                }

                if (A[aIndex] < B[bIndex]) {
                    aIndex++;
                    bIndex++;
                    answer++;
                }
            }

            return answer;
        }
    }
}
