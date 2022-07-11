package leetcode._103;/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    class TreeNodePos extends TreeNode {
        int pos;

        TreeNodePos(TreeNode node, int pos) {
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
            this.pos = pos;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNodePos> queue = new LinkedList<>();
        queue.addLast(new TreeNodePos(root, 1));

        boolean left = true;
        int curLevel = 1;
        List<Integer> curVals = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNodePos cur = queue.removeFirst();
            if (cur.pos >= Math.pow(2, curLevel)) {
                addToRes(left, curVals, res);
                curVals.clear();
                curLevel++;
                left = !left;
            }

            curVals.add(cur.val);
            if (cur.left != null)
                queue.addLast(new TreeNodePos(cur.left, cur.pos * 2));
            if (cur.right != null)
                queue.addLast(new TreeNodePos(cur.right, cur.pos * 2 + 1));
        }

        // 记得最后再加一次
        addToRes(left, curVals, res);

        return res;
    }

    private void addToRes(boolean left, List<Integer> curVals, List<List<Integer>> res) {
        if (!left)
            Collections.reverse(curVals);
        List<Integer> toAdd = new ArrayList<>(curVals);
        res.add(toAdd);
    }
}
// @lc code=end

