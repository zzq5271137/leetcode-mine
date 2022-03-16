package leetcode._202;/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

}
// @lc code=end

