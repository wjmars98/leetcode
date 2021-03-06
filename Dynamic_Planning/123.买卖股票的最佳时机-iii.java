/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) 
            return 0;
        int n = prices.length;
        int[][] dp = new int[n+1][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i=1; i<n; i++) {
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], prices[i] + dp[i][1]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], prices[i] + dp[i-1][3]);
        }

        return dp[n-1][4];

    }
}
// @lc code=end

