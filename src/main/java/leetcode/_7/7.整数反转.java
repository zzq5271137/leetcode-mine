package leetcode._7;
/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {

    public int reverse(int x) {
//        return official(x);
        return mine(x);
    }

    private int mine(int x) {
        if (x == 0)
            return 0;
        String xS = String.valueOf(x);
        char[] chars = xS.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean start = chars[chars.length - 1] != '0';
        int end = chars[0] == '-' ? 1 : 0;
        int i = chars.length - 1;
        for (; i >= end; i--) {
            if (!start && chars[i] != '0')
                start = true;
            if (start) {
                sb.append(chars[i]);
            }
        }
        String revertS = sb.toString();
        try {
            return end == 1 ? -1 * Integer.parseInt(revertS) : Integer.parseInt(revertS);
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * 记 rev 为翻转后的数字，为完成翻转，我们可以重复「弹出」xx 的末尾数字，将其「推入」rev 的末尾，直至 xx 为 0。
     * 要在没有辅助栈或数组的帮助下「弹出」和「推入」数字，我们可以使用如下数学方法：
     *
     * // 弹出 x 的末尾数字 digit
     * digit = x % 10
     * x /= 10
     * // 将数字 digit 推入 rev 末尾
     * rev = rev * 10 + digit
     */
    private int official(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
// @lc code=end

