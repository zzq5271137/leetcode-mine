package leetcode._148;/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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

    /*
     * 使用归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode firstSortedHalf = sortList(head);
        ListNode secondSortedHalf = sortList(secondHalf);

        ListNode dummyHead = new ListNode(0);
        ListNode sorted = dummyHead;
        while (firstSortedHalf != null && secondSortedHalf != null) {
            if (firstSortedHalf.val < secondSortedHalf.val) {
                ListNode firtNext = firstSortedHalf.next;
                firstSortedHalf.next = null;
                sorted.next = firstSortedHalf;
                firstSortedHalf = firtNext;
            } else {
                ListNode secondNext = secondSortedHalf.next;
                secondSortedHalf.next = null;
                sorted.next = secondSortedHalf;
                secondSortedHalf = secondNext;
            }
            sorted = sorted.next;
        }
        if (firstSortedHalf == null) {
            sorted.next = secondSortedHalf;
        } else if (secondSortedHalf == null) {
            sorted.next = firstSortedHalf;
        }
        return dummyHead.next;
    }
}
// @lc code=end
