package leetcode._100;/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return serialize(p).equals(serialize(q));
    }

    /*
     * 使用先序遍历进行序列化
     */
    private String serialize(TreeNode head) {
        return serialize(head, "");
    }

    private String serialize(TreeNode head, String res) {
        if (head == null) {
            res += "null,";
        } else {
            res += head.val + ",";
            res = serialize(head.left, res);
            res = serialize(head.right, res);
        }
        return res;
    }
}
// @lc code=end

