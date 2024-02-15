package leetcode._112;/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return this.bruteForce(root, targetSum);
    }

    private boolean bruteForce(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Set<Integer> allLeavesVal = new HashSet<>();
        this.traverse(root, allLeavesVal, 0);
        return allLeavesVal.contains(targetSum);
    }

    private void traverse(TreeNode root, Set<Integer> allLeavesVal, int curVal) {
        if (root == null) {
            return;
        }

        curVal = curVal + root.val;
        if (root.left == null && root.right == null) {
            allLeavesVal.add(curVal);
            return;
        }

        traverse(root.left, allLeavesVal, curVal);
        traverse(root.right, allLeavesVal, curVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode rLeft = new TreeNode();
        rLeft.val = 2;
        root.left = rLeft;
        boolean res = new Solution().hasPathSum(root, 2);
        System.out.println(res);
    }
}
// @lc code=end

