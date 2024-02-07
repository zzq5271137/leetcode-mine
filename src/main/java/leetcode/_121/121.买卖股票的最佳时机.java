package leetcode._121;/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // return this.bruteForce(prices);
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    //超时
    private int bruteForce(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit)
                    profit = prices[j] - prices[i];
            }
        }
        return profit;
    }
}
// @lc code=end

