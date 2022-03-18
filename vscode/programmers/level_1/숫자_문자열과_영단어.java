package programmers.level_1;

public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String s = "1234";

        Solution solution = new Solution();

        System.out.println(solution.solution(s));
    }

    static class Solution {
        public int solution(String s) {
            String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

            while (!s.matches("^[0-9]*$")) {
                for (int i = 0; i < numbers.length; i++) {
                    if (s.contains(numbers[i])) {
                        String prefix = s.substring(0, s.indexOf(numbers[i]));
                        String suffix = s.substring(s.indexOf(numbers[i]) + numbers[i].length());
                        s = prefix + i + suffix;
                    }
                }
            }

            return Integer.parseInt(s);
        }
    }
}
