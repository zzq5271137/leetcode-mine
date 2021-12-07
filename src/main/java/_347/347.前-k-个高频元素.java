package _347;/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

// @lc code=start
class Solution {

    /*
     * 使用java自带的优先队列实现
     */

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(key);
            else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] ret = new int[pq.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = pq.remove();
        }
        return ret;
    }
}
// @lc code=end

