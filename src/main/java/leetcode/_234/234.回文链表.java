package leetcode._234;/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

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
    public boolean isPalindrome(ListNode head) {
//        return useStackFullList(head);
//        return useStackHalfList(head);
        return notUseStack(head);
    }

    /*
     * 使用栈存储整个链表，然后从链表头节点开始遍历，和栈中的每一个元素进行比对是否相等
     */
    private boolean useStackFullList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }

    /*
     * 使用快慢指针，找到链表的中点位置（奇数长度找到中点，偶数长度找到双中点的第一个），然后使用栈存储后半部分链表，
     * 然后从头开始遍历链表直到中点位置，依次比较和栈中的元素是否相等
     */
    private boolean useStackHalfList(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.next.next == null)
            return head.val == head.next.val;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        Deque<ListNode> stack = new LinkedList<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }

        return true;
    }

    /*
     * 使用快慢指针，找到链表的中点位置（奇数长度找到中点，偶数长度找到双中点的第一个），然后将链表的后半部分反转，
     * 然后分别从链表的头、尾遍历直到中间，依次比较值是否相等
     */
    private boolean notUseStack(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.next.next == null)
            return head.val == head.next.val;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf;
        if (fast.next == null) {
            secondHalf = slow.next;
        } else {
            secondHalf = slow.next.next;
        }
        slow.next = null;

        ListNode tail = null;
        while (secondHalf != null) {
            ListNode next = secondHalf.next;
            secondHalf.next = tail;
            tail = secondHalf;
            secondHalf = next;
        }

        while (head != null) {
            if (head.val != tail.val)
                return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

}
// @lc code=end

