/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
// 动态规划，dp[i] 表示对i进行分解相乘能得到的最大值
// 对i进行分解，分别为i-j, j 所以 dp[i] = max(dp[i], dp[i-j]*j, (i-j)*j);
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i=3; i<=n; i++) {
            for (int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i-j]*j, (i-j)*j));
            }
        }
        return dp[n];
    }
}
// @lc code=end

