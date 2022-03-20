/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // dp数组为二维dp[i][0] 表示当前持有股票的最大现金
        // dp[i][1] 表示当前卖出股票的最大现金
        if(prices==null || prices.length==0) return 0;
        int length = prices.length;
        int[][] dp = new int[length+1][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i=1; i<prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i][0]);
        }
        return dp[length-1][1];
    }
}
// @lc code=end

