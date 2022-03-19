/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int end = (int) Math.sqrt(n);
        int[] nums = new int[end+1];
        for (int i=0; i<=end; i++) 
            nums[i] = i * i;
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i=0; i<=end; i++) {
            for (int j=nums[i]; j<=n; j++) {
                if (dp[j-nums[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j-nums[i]]+1, dp[j]);
            }
        }
        return dp[n];
        
    }
}
// @lc code=end

