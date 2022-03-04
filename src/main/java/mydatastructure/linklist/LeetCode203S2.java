package mydatastructure.linklist;

/*
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class LeetCode203S2 {
    static class ListNode {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode newHead = new LeetCode203S2().removeElements(head, 6);
        System.out.println(newHead);
    }
}
