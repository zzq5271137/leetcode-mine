package leetcode._82;/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.next != null && cur.next.val == cur.next.next.val) {
                ListNode stop = cur.next;
                while (stop.next != null && stop.val == stop.next.val)
                    stop = stop.next;
                ListNode stopNext = stop.next;
                stop.next = null;
                cur.next = stopNext;
                continue;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end

