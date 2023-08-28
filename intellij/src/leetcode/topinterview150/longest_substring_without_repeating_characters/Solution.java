package src.leetcode.topinterview150.longest_substring_without_repeating_characters;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String s = "ynyo";
        int result = new Solution().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        return 1;
    }

    public int lengthOfLongestSubstring_queue(String s) {
        Queue<Character> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (queue.contains(c)) {
                queue.poll();
            }

            queue.add(c);
            result = Math.max(result, queue.size());
        }

        return result;
    }
}