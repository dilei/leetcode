package leetcode.maximum_subarray;

import static java.lang.Integer.MIN_VALUE;

/**
 * Created by user on 2017/12/8.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
           return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        int globalMaxSum = nums[0];
        for (int i=1; i<len; i++) {
            // 保证是连续的序列
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            globalMaxSum  = Math.max(maxSum, globalMaxSum);
        }
        return globalMaxSum;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int [] nums = {};
        int sum = s.maxSubArray(nums);
        System.out.println(sum);
    }
}
