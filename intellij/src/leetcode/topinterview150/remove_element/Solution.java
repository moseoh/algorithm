package src.leetcode.topinterview150.remove_element;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;

        int answer = new Solution().removeElement(nums, val);
        System.out.println(answer);
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeElement1(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) nums[i] = Integer.MAX_VALUE;
            else count++;
        }
        Arrays.sort(nums);
        return count;
    }
}