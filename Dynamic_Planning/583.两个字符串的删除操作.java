/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    // 动态规划，搞清楚递推公式，这个问题也就迎刃而解。
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i=0; i<=n1; i++) dp[i][0] = i;
        for (int j=0; j<=n2; j++) dp[0][j] = j;

        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 2, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }
        return dp[n1][n2];
    }
}
// @lc code=end

