package leetcode._589;/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--)
                stack.addFirst(node.children.get(i));
        }
        return res;
    }
}
// @lc code=end

