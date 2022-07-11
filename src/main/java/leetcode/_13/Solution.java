package leetcode._13;/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolVals = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int curV = symbolVals.get(s.charAt(i));
            if (i < s.length() - 1 && curV < symbolVals.get(s.charAt(i + 1)))
                res -= curV;
            else
                res += curV;
        }
        return res;
    }
}
// @lc code=end

