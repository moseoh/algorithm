package src.leetcode.topinterview150.rotate_array;

class Solution {
    
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        int[] original = nums.clone();

        for (int i = 0; i < length; i++) {
            if (i < k) {
                nums[i] = original[length - k + i];
            } else {
                nums[i] = original[i - k];
            }
        }
    }
}