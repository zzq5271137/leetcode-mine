package leetcode._2;/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0, new ListNode());
        ListNode cur = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1V = l1 == null ? 0 : l1.val;
            int l2V = l2 == null ? 0 : l2.val;
            int sum = (l1V + l2V + carry) % 10;
            carry = (l1V + l2V + carry) / 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0)
            cur.next = new ListNode(carry);
        return dummyNode.next;
    }
}
// @lc code=end

