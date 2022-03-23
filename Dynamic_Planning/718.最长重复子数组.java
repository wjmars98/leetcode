/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null) return 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int res = 0;
        int[][] dp = new int[n1+1][n2+2];
        dp[0][0] = 0;
        for (int i=1; i<n1+1; i++) {
            for (int j=1; j<n2+1; j++) {
                if (nums1[i-1]==nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
// @lc code=end

