package leetcode._46;/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new LinkedList<>();
        traceback(nums, all, new LinkedList<Integer>());
        return all;
    }

    private void traceback(int[] nums, List<List<Integer>> all, List<Integer> path) {
        if (path.size() == nums.length) {
            all.add(new LinkedList<>(path));
            return;
        }

        for (int num : nums) {
            if (!path.contains(num)) {
                path.add(num);
                traceback(nums, all, path);
                path.remove(path.indexOf(num));
            }
        }
    }
}
// @lc code=end

