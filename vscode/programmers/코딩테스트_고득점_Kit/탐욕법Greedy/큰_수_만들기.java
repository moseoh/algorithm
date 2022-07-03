package programmers.코딩테스트_고득점_Kit.탐욕법Greedy;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        Solution s = new Solution();
        System.out.println(s.solution(number, k));
    }

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int length = number.length() - k;

            int start = 0;
            while (length > answer.length()) {
                int max = 0;
                int end = Math.min(start + length, number.length());
                System.out.println(start + " " + end);
                for (int i = start; i < end; i++) {
                    int num = number.charAt(i) - '0';
                    if (num > max) {
                        max = num;
                        start = i + 1;
                    }
                }
                answer.append(max);
            }

            return answer.toString();
        }
    }

    static class Solution1 {
        public String solution(String number, int k) {
            int count = 0;

            int index = 0;
            while (index < number.length() - 1) {
                if (count == k) {
                    break;
                }

                if (number.charAt(index) < number.charAt(index + 1)) {
                    String temp = number.substring(0, index) + number.substring(index + 1);
                    number = temp;
                    index = 0;
                    count++;
                } else {
                    index++;
                }
            }

            if (count != k) {
                number = number.substring(0, number.length() - k + count);
            }

            return number;
        }
    }
}
