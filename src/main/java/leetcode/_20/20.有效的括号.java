package leetcode._20;/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (c == ')' && stack.pop() != '(')
                    return false;
                if (c == '}' && stack.pop() != '{')
                    return false;
                if (c == ']' && stack.pop() != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
// @lc code=end
