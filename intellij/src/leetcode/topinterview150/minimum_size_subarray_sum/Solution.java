package src.leetcode.topinterview150.minimum_size_subarray_sum;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 2;
        int result = new Solution().minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = -1;
        int output = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                output = Math.min(output, i - left);
                left++;
                sum -= nums[left];
            }
        }

        return output == Integer.MAX_VALUE ? 0 : output;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= target) {
                result = Math.min(result, end - start);
                sum -= nums[start++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen_timeLimit(int target, int[] nums) {
        for (int length = 1; length <= nums.length; length++) {
            for (int i = 0; i <= nums.length - length; i++) {
                int sum = 0;
                for (int j = i; j < i + length; j++) {
                    sum += nums[j];
                }
                if (sum >= target) return length;
            }
        }
        return 0;
    }
}