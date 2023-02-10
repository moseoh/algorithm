package src.programmers.archive.Level2.문자열압축;

public class Solution {
    public static void main(String[] args) {
        String s1 = "aabbaccc";
//        String s = "ababcdcdababcdcd"	;
//        String s = "abcabcdede"	;
//        String s1 = "abcabcabcabcdededededede";
        String s2 = "xababcdcdababcdcd";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 1; i <= (s.length() / 2) + 1; i++) {
            int result = compressedString(s, i, 1).length();
            answer = i == 1 ? result : Math.min(answer, result);
        }

        return answer;
    }

    public static StringBuilder compressedString(String s, int n, int repeat) {
        if (s.length() < n) return new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        String preString = s.substring(0, n);
        String postString = s.substring(n);

        if (!postString.startsWith(preString)) {
            if (repeat == 1) return sb.append(preString).append(compressedString(postString, n, 1));
            return sb.append(repeat).append(preString).append(compressedString(postString, n, 1));
        }

        return sb.append(compressedString(postString, n, repeat + 1));
    }

    public static int solution2(String s) {
        int answer = s.length();
        int maxLength = answer / 2;
        for (int i = 1; i <= maxLength; i++) {
            answer = Math.min(answer, getCompressedStringLength(s, i));
        }

        return answer;
    }

    public static int getCompressedStringLength(String s, int length) {
        StringBuilder sb = new StringBuilder();
        String target = s.substring(0, length);
        String compare;

        int cnt = 1;
        for (int i = length; i <= s.length(); i += length) {
            if (i + length > s.length()) {
                compare = s.substring(i);
            } else {
                compare = s.substring(i, i + length);
            }

            if (target.equals(compare)) {
                cnt++;
            } else {
                if (cnt != 1) {
                    sb.append(cnt);
                }
                sb.append(target);
                target = compare;
                cnt = 1;
            }
        }
        sb.append(target);
        return sb.length();
    }
}
