package mydatastructure.binarysearchtree;

/*
 * 实现二分搜索树
 */

import java.util.*;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public BST(E[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Create BST failed. Illegal arr.");
        for (E e : arr) add(e);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.equals(node.e))
            return true;

        if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else  // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        Node head = root;
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.e + " ");
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
        }
        System.out.println();
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void inOrderNR() {
        Node head = root;
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.e + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void postOrderNR() {
        Node head = root;
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null)
                    s1.push(head.left);
                if (head.right != null)
                    s1.push(head.right);
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().e + " ");
            }
        }
        System.out.println();
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur != null) {
                System.out.println(cur.e);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
    }

    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");

        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = minimum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {  // e.equals(node.e)
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    /*
     * 统计树的最大宽度，借助map实现。
     *
     * 注意，这里的最大宽度不包含null节点，即这里只统计每层的不包含null的节点数量；
     * 另一种树的宽度，是包含null，详见leetcode-662。
     */
    public int maxWidthUseMap() {
        Node head = root;
        if (head == null)
            return 0;

        Deque<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();  // 存储节点和其对应的层数
        levelMap.put(head, 1);
        int curLevel = 1;  // 当前正在统计哪一层的宽度
        int curLevelNodes = 0;  // 当前层，宽度是多少
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    /*
     * 统计树的最大宽度，不借助map。
     *
     * 注意，这里的最大宽度不包含null节点，即这里只统计每层的不包含null的节点数量；
     * 另一种树的宽度，是包含null，详见leetcode-662。
     */
    public int maxWidthNotUseMap1() {
        Node head = root;
        if (head == null)
            return 0;

        Deque<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;  // 当前层，最右节点是谁
        Node nextEnd = null;  // 下一层，最右节点是谁
        int max = 0;
        int curLevelNodes = 0;  // 当前层的节点数
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }

    /*
     * 统计树的最大宽度，不借助map。
     *
     * 注意，这里的最大宽度不包含null节点，即这里只统计每层的不包含null的节点数量；
     * 另一种树的宽度，是包含null，详见leetcode-662。
     */
    public int maxWidthNotUseMap2() {
        Node head = root;
        if (head == null)
            return 0;

        Deque<Node> queue = new LinkedList<>();
        queue.add(head);
        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int curLevelNodes = queue.size();
            for (int i = 0; i < curLevelNodes; i++) {
                Node node = queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            maxWidth = Math.max(maxWidth, curLevelNodes);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
//        testPrint();
//        testRemoveMin();
        testRemove();
    }

    private static void testRemove() {
        BST<Integer> bst = new BST<>(new Integer[]{4, 1, 3, 8, 6, 7, 2, 5});
        bst.inOrder();
        bst.remove(5);
        System.out.println();
        bst.inOrder();
    }

    private static void testRemoveMin() {
        BST<Integer> bst = new BST<>();
        Random r = new Random();
        int n = 20;
        for (int i = 0; i < n; i++) {
            bst.add(r.nextInt(10000));
        }
        List<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("removeMin test complete.");
    }

    private static void testPrint() {
        BST<Integer> bst = new BST<>(new Integer[]{5, 3, 6, 8, 4, 2});

        bst.preOrder();  // 5,3,2,4,6,8
        System.out.println();

//        System.out.println(bst);

        bst.inOrder();  // 2,3,4,5,6,8
        System.out.println();

        bst.postOrder();  // 2,4,3,8,6,5
        System.out.println();

        bst.preOrderNR();  // 5,3,2,4,6,8
        System.out.println();

        bst.levelOrder();  // 5,3,6,2,4,8
        System.out.println();
    }
}
