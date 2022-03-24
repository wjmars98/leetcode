/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if(dp[l1][l2] == l1) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

