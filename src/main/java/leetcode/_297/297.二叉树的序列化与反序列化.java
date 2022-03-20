package leetcode._297;/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

import java.util.Arrays;
import java.util.Deque;
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

    /*
     * 序列化
     */
    public String serialize(TreeNode root) {
//        return preOrderSerialize(root);
        return levelOrderSerialize(root);
    }

    private String preOrderSerialize(TreeNode root) {
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

    private String levelOrderSerialize(TreeNode root) {
        if (root == null)
            return "null,";

        StringBuilder res = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                res.append("null,");
            } else {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return res.toString();
    }

    /*
     * 反序列化
     */
    public TreeNode deserialize(String data) {
//        return preOrderDeserialize(data);
        return levelOrderDeserialize(data);
    }

    private TreeNode preOrderDeserialize(String data) {
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

    private TreeNode levelOrderDeserialize(String data) {
        List<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        String val = dataList.remove(0);
        TreeNode head = null;
        if (!val.equals("null")) {
            Deque<TreeNode> queue = new LinkedList<>();
            head = new TreeNode(Integer.parseInt(val));
            queue.add(head);
            TreeNode node;
            while (!queue.isEmpty()) {
                node = queue.remove();
                node.left = generateNode(dataList.remove(0));
                node.right = generateNode(dataList.remove(0));
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return head;
    }

    private TreeNode generateNode(String val) {
        if (val.equals("null"))
            return null;
        return new TreeNode(Integer.parseInt(val));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

