package programmers.level_1;

import java.util.ArrayList;
import java.util.List;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        System.out.println(new Solution().solution(left, right));
    }

    static class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            List<Integer> oddNum = new ArrayList<>();
            for (int i = 1;; i++) {
                if (i * i >= 1000) {
                    break;
                }
                oddNum.add(i * i);
            }

            for (int i = left; i <= right; i++) {
                if (oddNum.contains(i)) {
                    answer -= i;
                } else {
                    answer += i;
                }
            }

            return answer;
        }
    }
}
