package leetcode._136;/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];  // 数组中数字两两相同，只有一个不一样，使用亦或位运算，那么两两相同的数亦或之后是0，最终得到的就是那个唯一单独的数字
            }
        }
        return ans;
    }
}
// @lc code=end

