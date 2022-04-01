package programmers.level_1;

public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public boolean solution(String s) {

            if (s.length() != 4 && s.length() != 6)
                return false;

            if (s.matches("^[0-9]*$"))
                return true;

            return false;
        }
    }
}
