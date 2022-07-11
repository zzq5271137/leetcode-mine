package leetcode._252;/*
 * @lc app=leetcode.cn id=252 lang=java
 *
 * [252] 会议室
 */

import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }
        return true;
    }
}
// @lc code=end

