package leetcode._145;/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return recursive(root);
//        return nonRecursive(root);
    }

    private List<Integer> recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    private void recursive(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        recursive(node.left, res);
        recursive(node.right, res);
        res.add(node.val);
    }

    private List<Integer> nonRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null)
                s1.push(root.left);
            if (root.right != null)
                s1.push(root.right);
        }
        while (!s2.isEmpty())
            res.add(s2.pop().val);

        return res;
    }

}
// @lc code=end

