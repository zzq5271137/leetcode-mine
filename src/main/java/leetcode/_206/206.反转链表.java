package leetcode._206;/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
//        return traverse(head);
        return recursive(head);
    }

    private ListNode traverse(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curNext;
        }
        return newHead;
    }


    private ListNode recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
// @lc code=end

