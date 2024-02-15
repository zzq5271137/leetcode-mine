package leetcode._78;/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        traceback(nums, res, new LinkedList<Integer>(), 0);
        return res;
    }

    private void traceback(int[] nums, List<List<Integer>> res, List<Integer> path, int index) {
        if (nums.length == index) {
            res.add(new LinkedList<>(path));
            return;
        }

        int num = nums[index];
        traceback(nums, res, path, index + 1);  // 不用
        path.add(num);
        traceback(nums, res, path, index + 1); // 用
        path.remove(path.indexOf(num));
    }
}
// @lc code=end

