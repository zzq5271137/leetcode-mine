package leetcode._253;/*
 * @lc app=leetcode.cn id=253 lang=java
 *
 * [253] 会议室 II
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 按会议开始的时间将会议排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 最小堆（java的优先队列默认是最小堆）
        // 记录目前已安排会议的结束时间
        PriorityQueue<Integer> allocator = new PriorityQueue<>();

        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek())
                allocator.remove();
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

}
// @lc code=end

