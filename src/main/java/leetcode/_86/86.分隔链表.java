package leetcode._86;/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = null;
        ListNode lTail = null;
        ListNode oHead = null;
        ListNode oTail = null;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                if (lHead == null) {
                    lHead = lTail = cur;
                } else {
                    lTail.next = cur;
                    lTail = cur;
                }
            } else {
                if (oHead == null) {
                    oHead = oTail = cur;
                } else {
                    oTail.next = cur;
                    oTail = cur;
                }
            }
            cur.next = null;
            cur = next;
        }

        ListNode newHead;
        if (lHead != null) {
            newHead = lHead;
            lTail.next = oHead;
        } else {
            newHead = oHead;
        }
        return newHead;
    }
}
// @lc code=end

