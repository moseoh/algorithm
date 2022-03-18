package programmers.level_1;

import java.util.HashSet;
import java.util.Set;

public class 키패드_누르기 {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String hand = "right";

        Solution solution = new Solution();

        System.out.println(solution.solution(numbers, hand));
    }

    static class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();

            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            int lastLeft = 10, lastRight = 12;

            left.add(1);
            left.add(4);
            left.add(7);

            right.add(3);
            right.add(6);
            right.add(9);

            for (int number : numbers) {
                if (number == 0)
                    number = 11;

                if (right.contains(number)) {
                    sb.append("R");
                    lastRight = number;
                    continue;
                }

                if (left.contains(number)) {
                    sb.append("L");
                    lastLeft = number;
                    continue;
                }

                int leftDistance = ((lastLeft - number) / 3) + ((lastLeft - number) % 3);
                int rightDistance = ((lastRight - number) / 3) + ((lastRight - number) % 3);
                leftDistance = Math.abs(leftDistance);
                rightDistance = Math.abs(rightDistance);

                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        lastRight = number;

                    } else {
                        sb.append("L");
                        lastLeft = number;

                    }
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    lastRight = number;

                } else {
                    sb.append("L");
                    lastLeft = number;

                }

            }

            return sb.toString();
        }
    }
}
