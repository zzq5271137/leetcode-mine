package leetcode._331;/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] data = preorder.split(",");
        if (data.length == 1 && data[0].equals("#"))
            return true;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (String s : data) {
            if (stack.isEmpty())
                return false;
            stack.pop();
            if (!s.equals("#")) {
                stack.push(0);
                stack.push(0);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

