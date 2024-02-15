package leetcode._31;/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int firstIncreaseIndex = -1;
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {
                firstIncreaseIndex = j;
                break;
            }
        }

        if (firstIncreaseIndex == -1) {
            reverse(nums, 0);
            return;
        }

        int firstGreaterIndex = firstIncreaseIndex;
        while (firstGreaterIndex + 1 < nums.length && nums[firstGreaterIndex + 1] > nums[firstIncreaseIndex - 1])
            firstGreaterIndex++;

        sweap(nums, firstIncreaseIndex - 1, firstGreaterIndex);
        reverse(nums, firstIncreaseIndex);
    }

    private void reverse(int[] nums, int index) {
        int tail = nums.length - 1;
        while (index < tail) {
            sweap(nums, index, tail);
            index++;
            tail--;
        }
    }

    private void sweap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

