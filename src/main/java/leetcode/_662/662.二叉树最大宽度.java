package leetcode._662;/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

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

    public int widthOfBinaryTree(TreeNode root) {
//        return good(root);
        return mine(root);
    }

    private int mine(TreeNode root) {
        class AnnotatedNode {
            TreeNode node;
            int depth, position;

            AnnotatedNode(TreeNode node, int depth, int position) {
                this.node = node;
                this.depth = depth;
                this.position = position;
            }
        }

        Deque<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0;
        int maxLength = 0;
        int left = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode annotatedNode = queue.remove();
            if (annotatedNode.node != null) {
                queue.add(new AnnotatedNode(annotatedNode.node.left, annotatedNode.depth + 1, annotatedNode.position * 2));
                queue.add(new AnnotatedNode(annotatedNode.node.right, annotatedNode.depth + 1, annotatedNode.position * 2 + 1));
                if (curDepth != annotatedNode.depth) {
                    curDepth = annotatedNode.depth;
                    left = annotatedNode.position;
                }
                maxLength = Math.max(maxLength, annotatedNode.position - left + 1);
            }
        }
        return maxLength;
    }

    private int good(TreeNode root) {
        class AnnotatedNode {
            TreeNode node;
            int depth, pos;

            AnnotatedNode(TreeNode n, int d, int p) {
                node = n;
                depth = d;
                pos = p;
            }
        }

        Deque<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.remove();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

}

// @lc code=end

