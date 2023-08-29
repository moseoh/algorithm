package src.leetcode.topinterview150.ransom_note;

class Solution {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean result = new Solution().canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 97]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 97;
            if (arr[index] == 0) return false;
            arr[index]--;
        }

        return true;
    }
}

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

magazine의 문자를 사용하여 ransomNote를 구성할 수 있다면 true를 반환.
한번씩만 쓸수 있다.
 */