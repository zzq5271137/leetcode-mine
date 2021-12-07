package _303;/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    private int[] sum; // sum[i]存储的是前i个元素的和

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

