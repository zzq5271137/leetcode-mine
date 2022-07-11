package leetcode._暴力递归._不申请额外的数据结构逆序一个栈;

import java.util.LinkedList;

public class Solution {

    public static void reverseStack(LinkedList<Integer> stack) {
        if (stack.isEmpty())
            return;

        int last = getBottom(stack);
        reverseStack(stack);
        stack.push(last);
    }

    private static int getBottom(LinkedList<Integer> stack) {
        Integer result = stack.removeFirst();
        if (stack.isEmpty())
            return result;

        int prev = getBottom(stack);
        stack.addFirst(result);
        return prev;
    }

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(1);
        stack.addFirst(3);
        stack.addFirst(5);
        stack.addFirst(7);
        stack.addFirst(9);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

}
