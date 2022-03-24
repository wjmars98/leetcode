/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // 这题有些细节需要考虑清楚，增删改其实是类似的，注意递推公式
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        for (int i=0; i<=n1; i++) dp[i][0] = i;
        for (int j=0; j<=n2; j++) dp[0][j] = j;
        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1, Math.min(dp[i][j-1]+1, dp[i-1][j-1] + 1));
                }
            }
        }
        return dp[n1][n2];
    }
}
// @lc code=end

