package leetcode._17;/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> all = new ArrayList<>();
        if (digits.length() == 0)
            return all;

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        traceback(digits, phoneMap, all, 0, new StringBuilder());
        return all;
    }

    private void traceback(String digits, Map<Character, String> phoneMap, List<String> all, int index, StringBuilder comb) {
        if (index == digits.length()) {
            all.add(comb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String strs = phoneMap.get(digit);
        for (int i = 0; i < strs.length(); i++) {
            comb.append(strs.charAt(i));
            traceback(digits, phoneMap, all, index + 1, comb);
            comb.deleteCharAt(index);
        }
    }

}
// @lc code=end
