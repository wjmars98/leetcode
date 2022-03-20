/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[n-1][1];
    }
}
// @lc code=end

