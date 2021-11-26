package _203;/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class _203.ListNode {
 * int val;
 * _203.ListNode next;
 * _203.ListNode() {}
 * _203.ListNode(int val) { this.val = val; }
 * _203.ListNode(int val, _203.ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Wrong arr");
        this.val = arr[0];

        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        String connector = " -> ";
        StringBuilder res = new StringBuilder();
        for (ListNode cur = this; cur != null; cur = cur.next)
            res.append(cur.val + connector);
        res.append("NULL");
        return res.toString();
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
// @lc code=end

