package src.leetcode.topinterview150.valid_anagram;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        boolean result = new Solution().isAnagram(s, t);
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        return sortedString(s).equals(sortedString(t));
    }

    private String sortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean isAnagram2(String s, String t) {
        int[] arr = new int[26];

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (arr[index] == 0) return false;
            arr[index]--;
        }

        for (int a : arr) {
            if (a != 0) return false;
        }

        return true;
    }
}

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

t가 s의 애너그램이면 true.
애너그램은 모든 문자를 한번씩 사용하여 재배치하여 다른 문자를 만들 수 있는지
 */