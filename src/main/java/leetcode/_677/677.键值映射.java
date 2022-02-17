package leetcode._677;/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */

import java.util.TreeMap;

// @lc code=start
class MapSum {

    private class Node {
        int value;
        TreeMap<Character, Node> next;

        Node() {
            this.value = 0;
            this.next = new TreeMap<>();
        }
    }

    private Node root;

    public MapSum() {
        this.root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {
        if (node.next.size() == 0)
            return node.value;

        int sum = node.value;
        for (char nextKey : node.next.keySet())
            sum += sum(node.next.get(nextKey));
        return sum;
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

