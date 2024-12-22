package leetcode._122;/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {

    private int res;

    public int maxProfit(int[] prices) {
//        return this.bruteForce(prices);
//        return this.greedy(prices);
        return this.dp(prices);
    }

    //超时
    public int bruteForce(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }

        // 什么都不做，进行下一天
        dfs(prices, index + 1, len, status, profit);

        if (status == 0) {
            // 可以尝试转向 1
            dfs(prices, index + 1, len, 1, profit - prices[index]);
        } else {
            // 可以尝试转向 0
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }

    //贪心
    public int greedy(int[] prices) {
        int totalProfit = 0;
        // 遍历价格数组，只要后一天比前一天价格高，就可以进行交易
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }

    //动态规划
    public int dp(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 状态定义
        // dp[i][0] 表示第i天不持有股票的最大利润
        // dp[i][1] 表示第i天持有股票的最大利润
        int[][] dp = new int[len][2];

        // 初始状态
        dp[0][0] = 0;                // 第一天不持有
        dp[0][1] = -prices[0];       // 第一天买入

        // 状态转移
        for (int i = 1; i < len; i++) {
            // 第i天不持有股票的最大利润 = max(前一天不持有，前一天持有今天卖出)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 第i天持有股票的最大利润 = max(前一天持有，前一天不持有今天买入)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 返回结果
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
// @lc code=end

