package leetcode._209;
/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        return mine(target, nums);
    }

    private int mine(int target, int[] nums) {
        int minLen = nums.length;
        boolean found = false;
        int curSum = 0;
        int left = 0, right = 0;

        for (; right < nums.length; right++) {
            curSum += nums[right];
            if (curSum >= target) {
                found = true;
                while (left <= right && (curSum - nums[left] >= target)) {
                    curSum -= nums[left];
                    left++;
                }
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return found ? minLen : 0;
    }

}
// @lc code=end

