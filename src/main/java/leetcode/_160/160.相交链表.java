package leetcode._160;/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return useHash(headA, headB);
        return useDoublePointer(headA, headB);
    }

    private ListNode useDoublePointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    private ListNode useHash(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        ListNode curA = headA;
        while (curA != null) {
            setA.add(curA);
            curA = curA.next;
        }

        ListNode res = null;
        ListNode curB = headB;
        while (curB != null) {
            if (setA.contains(curB)) {
                res = curB;
                break;
            }
            curB = curB.next;
        }
        return res;
    }
}
// @lc code=end

