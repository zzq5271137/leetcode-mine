package leetcode._9;
/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        Deque<Character> stack = new LinkedList<>();
        char[] chars = String.valueOf(x).toCharArray();
        int len = chars.length;

        for (int i = 0 ; i < len / 2 ; i ++)
            stack.addFirst(chars[i]);

        int halfStart = (len & 1) == 1 ? len / 2 + 1 : len / 2;

        for (;halfStart < len; halfStart++)
            if (stack.removeFirst() != chars[halfStart])
                return false;

        return true;
    }

}
// @lc code=end

