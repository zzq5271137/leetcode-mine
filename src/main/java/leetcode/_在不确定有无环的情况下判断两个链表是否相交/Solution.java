package leetcode._在不确定有无环的情况下判断两个链表是否相交;

public class Solution {

    public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;

        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null)
            return noLoop(head1, head2);

        if (loop1 != null && loop2 != null)
            return bothLoop(head1, loop1, head2, loop2);

        return null;  // 若两个链表相交，则要么都有环，要么都没环，一个有环一个没环一定不相交
    }

    private static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null)
                return null; // 无环
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;

        ListNode cur1 = head1;
        ListNode cur2 = head2;

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

        cur1 = n > 0 ? head1 : head2;  // 谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;  // 谁短，谁的头变成cur2

        /*
         * 先消耗掉长度相差的部分
         */
        n = Math.abs(n);
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

    private static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2) {  // 表明相交的点在环外
            cur1 = head1;
            cur2 = head2;

            /*
             * 计算出两个链表的长度差
             */
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;  // 谁长，谁的头变成cur1
            cur2 = cur1 == head1 ? head2 : head1;  // 谁短，谁的头变成cur2

            /*
             * 先消耗掉长度相差的部分
             */
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

}
