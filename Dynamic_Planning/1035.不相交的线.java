/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] 不相交的线
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，
        // text1[i - 1] 与 text2[j - 1]不相同
        if (nums1==null || nums2==null)
            return 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        // dp[i][j]：长度为[0, i - 1]的字符串text1与
        // 长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
// @lc code=end

