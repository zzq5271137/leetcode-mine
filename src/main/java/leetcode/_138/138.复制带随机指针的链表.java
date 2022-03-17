package leetcode._138;/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node old = entry.getKey();
            Node copied = entry.getValue();
            copied.next = map.get(old.next);
            copied.random = map.get(old.random);
        }
        return map.get(head);
    }
}
// @lc code=end

