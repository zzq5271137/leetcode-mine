package leetcode._23;/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

import java.util.Comparator;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
//        return usingHeap(lists);
        return usingDividAndConquer(lists);
    }

    private ListNode usingHeap(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists)
            if (node != null)
                heap.add(node);

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            ListNode toAdd = heap.remove();
            cur.next = toAdd;
            cur = cur.next;
            toAdd = toAdd.next;
            if (toAdd != null)
                heap.add(toAdd);
        }
        return dummy.next;
    }

    // 归并排序的思路（分治）
    private ListNode usingDividAndConquer(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l > r)
            return null;

        int mid = l + ((r - l) >> 1);
        return mergeTwo(mergeSort(lists, l, mid), mergeSort(lists, mid + 1, r));
    }

    private ListNode mergeTwo(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return dummy.next;
    }
}
// @lc code=end

