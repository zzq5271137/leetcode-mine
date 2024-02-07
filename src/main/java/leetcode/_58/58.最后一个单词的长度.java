package leetcode._58;/*
                     * @lc app=leetcode.cn id=58 lang=java
                     *
                     * [58] 最后一个单词的长度
                     */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--; 
        if (end < 0) return 0;
        int len = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
            len++;
        }
        return len;
    }
}
// @lc code=end
