package leetcode._316;
/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */


import java.util.*;

// @lc code=start
class Solution {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cMap.containsKey(c))
                cMap.put(c, cMap.get(c) + 1);
            else
                cMap.put(c, 1);
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            cMap.put(c, cMap.get(c) - 1);

            if (stack.isEmpty()) {
                stack.addFirst(c);
                continue;
            }

            if (stack.contains(c))
                continue;

            while (!stack.isEmpty() && stack.peekFirst() > c && cMap.get(stack.peekFirst()) != 0)
                stack.removeFirst();

            stack.addFirst(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.removeLast());
        return sb.toString();
    }

}
// @lc code=end

