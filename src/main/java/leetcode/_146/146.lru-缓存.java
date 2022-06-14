package leetcode._146;/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev, next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> storage = new HashMap<>();
    private int capacity;
    private Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }

    public int get(int key) {
        Node ret = storage.get(key);
        if (ret == null)
            return -1;

        moveToHead(ret);
        return ret.value;
    }

    public void put(int key, int value) {
        Node ins = storage.get(key);
        if (ins == null) {
            ins = new Node(key, value);
            storage.put(key, ins);
            addToHead(ins);
            if (storage.size() > capacity) {
                Node rem = removeTail();
                storage.remove(rem.key);
            }
        } else {
            ins.value = value;
            moveToHead(ins);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        dummyHead.next.prev = node;
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next = node;
    }

    private Node removeTail() {
        Node rem = dummyTail.prev;
        rem.prev.next = dummyTail;
        dummyTail.prev = rem.prev;
        return rem;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

