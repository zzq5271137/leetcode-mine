package leetcode._114;/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            //左子树为 null，直接考虑下一个节点
            if (cur.left == null)
                cur = cur.right;
            else {
                // 找左子树最右边的节点
                TreeNode preNode = cur.left;
                while (preNode.right != null)
                    preNode = preNode.right;
                //将原来的右子树接到左子树的最右边节点
                preNode.right = cur.right;
                // 将左子树插入到右子树的地方
                cur.right = cur.left;
                cur.left = null;
                // 考虑下一个节点
                cur = cur.right;
            }
        }
    }
}
// @lc code=end

