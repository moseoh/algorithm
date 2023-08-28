package src.leetcode.topinterview150.valid_palindrome;

class Solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = new Solution().isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]", "");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}