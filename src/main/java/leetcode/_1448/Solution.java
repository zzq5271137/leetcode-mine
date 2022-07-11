package leetcode._1448;/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
 */

import java.util.TreeMap;

// @lc code=start
class Solution {

    int res = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;

        int v = root.val;
        if (map.isEmpty() || map.lastEntry().getKey() <= v)
            res++;

        map.put(v, map.getOrDefault(v, 0) + 1);

        dfs(root.left);

        if (root.left != null)
            decr(root.left.val);

        dfs(root.right);

        if (root.right != null)
            decr(root.right.val);
    }

    public void decr(int v) {
        int n = map.get(v);

        if (n == 1)
            map.remove(v);
        else
            map.put(v, n - 1);
    }

}
// @lc code=end
