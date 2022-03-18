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
//        return useDoublePointer(headA, headB);
        return useDoublePointer2(headA, headB);
    }

    private ListNode useDoublePointer2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode cur1 = headA;
        ListNode cur2 = headB;

        /*
         * 计算出两个链表的长度差
         */
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2)
            return null;

        cur1 = n > 0 ? headA : headB;  // 谁长，谁的头变成cur1
        cur2 = cur1 == headA ? headB : headA;  // 谁短，谁的头变成cur2

        n = Math.abs(n);

        /*
         * 先消耗掉长度相差的部分
         */
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private ListNode useDoublePointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
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

