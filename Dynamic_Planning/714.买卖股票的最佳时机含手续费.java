/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices==null || prices.length==0)
            return -1;
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = -prices[0];
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            // 由于需要添加手续费，递推公式会有变化
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0] - fee);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
// @lc code=end

