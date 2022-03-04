package mydatastructure.binarysearchtree;

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
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur != null) {
                System.out.println(cur.e);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
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
