package leetcode._297;/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    public String serialize(TreeNode root) {
        return preOrderSerialize(root, "");
    }

    private String preOrderSerialize(TreeNode node, String res) {
        if (node == null) {
            res += "null,";
            return res;
        }

        res += node.val + ",";
        res = preOrderSerialize(node.left, res);
        res = preOrderSerialize(node.right, res);
        return res;
    }


    public TreeNode deserialize(String data) {
        List<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        return preOrderDeserialize(dataList);
    }

    private TreeNode preOrderDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        node.left = preOrderDeserialize(dataList);
        node.right = preOrderDeserialize(dataList);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

