package leetcode._643;/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        int curSum = 0;
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (right - left + 1 <= k) {
                curSum += nums[right];
                maxSum = curSum;
            } else {
                curSum = curSum - nums[left] + nums[right];
                maxSum = Math.max(maxSum, curSum);
                left++;
            }
        }
        return maxSum * 1.0 / k;
    }
}
// @lc code=end

