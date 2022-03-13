package leetcode._590;/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> postorder(Node root) {
//        return recursive(root);
        return nonRecursive(root);
    }

    public List<Integer> nonRecursive(Node root) {
        List<Integer> vals = new LinkedList<>();
        Deque<Object[]> stack = new LinkedList<>();
        stack.push(new Object[]{0, root});
        while (!stack.isEmpty()) {
            Object[] poped = stack.pop();
            Integer num = (Integer) poped[0];
            Node cur = (Node) poped[1];

            if (cur == null)
                continue;
            if (num == cur.children.size())
                vals.add(cur.val);

            if (num < cur.children.size()) {
                stack.push(new Object[]{num + 1, cur});
                stack.push(new Object[]{0, cur.children.get(num)});
            }
        }
        return vals;
    }

    private List<Integer> recursive(Node root) {
        List<Integer> vals = new LinkedList<>();
        postorder(root, vals);
        return vals;
    }

    private void postorder(Node node, List<Integer> vals) {
        if (node == null)
            return;

        List<Node> children = node.children;
        children.forEach(c -> postorder(c, vals));
        vals.add(node.val);
    }
}
// @lc code=end

