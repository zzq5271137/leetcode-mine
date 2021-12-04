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
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o1.compareTo(o2);
            }
        });

        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        int[] ret = new int[pq.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = pq.remove().e;
        }
        return ret;
    }
}
// @lc code=end

