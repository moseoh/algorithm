package src.leetcode.topinterview150.jump_game;

class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{3, 2, 1, 0, 4};

        System.out.println(new Solution().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int index = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] + i >= index) {
                index = i;
            }
        }
        return index == 0;
    }
}