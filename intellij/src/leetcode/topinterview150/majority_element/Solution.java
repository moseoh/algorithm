package src.leetcode.topinterview150.majority_element;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};

        int answer = new Solution().majorityElement(nums);
        System.out.println(answer);
    }

    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
                if (count > n) return nums[i];
            }
        }
        return -1;
    }
}