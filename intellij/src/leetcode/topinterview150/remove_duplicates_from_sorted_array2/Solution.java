package src.leetcode.topinterview150.remove_duplicates_from_sorted_array2;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        new Solution().removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
        int duplicatedCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                duplicatedCount = 1;
            } else if (nums[i] == nums[i - 1] && duplicatedCount < 2) {
                nums[index++] = nums[i];
                duplicatedCount++;
            }
        }

        return index;
    }
}