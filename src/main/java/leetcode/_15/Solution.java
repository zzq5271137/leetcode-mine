package leetcode._15;/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//       return official(nums);
        return mine(nums);
    }

    private List<List<Integer>> mine(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return res;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int cur = nums[i];
            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int temp = nums[L] + nums[R] + cur;
                if (temp == 0) {
                    res.add(Arrays.asList(cur, nums[L], nums[R]));
                    while (L < R && nums[L + 1] == nums[L])
                        L++;
                    while (L < R && nums[R - 1] == nums[R])
                        R--;

                    L++;
                    R--;
                } else if (temp < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return res;
    }

    private List<List<Integer>> official(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0)
                return lists;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int curr = nums[i];

            int L = i + 1, R = len - 1;

            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    lists.add(Arrays.asList(curr, nums[L], nums[R]));

                    while (L < R && nums[L + 1] == nums[L])
                        ++L;

                    while (L < R && nums[R - 1] == nums[R])
                        --R;

                    ++L;
                    --R;
                } else if (tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }


}
// @lc code=end

