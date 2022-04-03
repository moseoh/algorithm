package programmers.level_1;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new StringBuilder(new String(ch)).reverse().toString();
        }
    }
}