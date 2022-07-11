package leetcode._56;/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] toAdd = intervals[i];
            while (i + 1 < intervals.length && toAdd[1] >= intervals[i + 1][0]) {
                toAdd[1] = Math.max(intervals[i + 1][1], toAdd[1]);
                i = i + 1;
            }
            merged.add(toAdd);
        }

        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            res[i] = merged.get(i);
        }

        return res;
    }
}
// @lc code=end

