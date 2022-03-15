package leetcode._21;/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        return traverse(list1, list2);
        return recursive(list1, list2);
    }

    private ListNode recursive(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = recursive(list1.next, list2);
            return list1;
        } else {
            list2.next = recursive(list1, list2.next);
            return list2;
        }
    }

    private ListNode traverse(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }
}
// @lc code=end

