package mydatastructure.linklist.recursion;

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

public class LeetCode203S4Recursive {
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

    public ListNode removeElements(ListNode head, int val, int depth) { // depth: 递归深度，用作调试使用
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.printf("Call: remove %d in %s%n", val, head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.printf("After remove %d: %s%n", val, res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode newHead = new LeetCode203S4Recursive().removeElements(head, 6, 0);
        System.out.println(newHead);
    }
}
