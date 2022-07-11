package leetcode._19;/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;
        for (int i = 0; i < n; i++)
            p2 = p2.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return dummyHead.next;
    }
}
// @lc code=end

