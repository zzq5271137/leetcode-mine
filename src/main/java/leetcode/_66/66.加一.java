package leetcode._66;/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> resRev = new ArrayList<>();
        int preOverflow = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int d = digits[i];
            int resD = d + preOverflow;
            if (resD >= 10) {
                preOverflow = 1;
                resD = resD - 10;
            } else {
                preOverflow = 0;
            }
            resRev.add(resD);
        }
        if (preOverflow == 1) {
            resRev.add(1);
        }
        int[] resArr = new int[resRev.size()];
        for (int i = resRev.size() - 1; i >= 0; i--) {
            resArr[resRev.size() - 1 - i] = resRev.get(i);
        }
        return resArr;
    }
}
// @lc code=end

