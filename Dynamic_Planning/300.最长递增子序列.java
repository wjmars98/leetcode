/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    // 典型的动态规划算法，要理解是如何推出递推公式的
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1)
            return nums.length;
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i=0; i<n; i++)
            dp[i] = 1;
        int res = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }
}
// @lc code=end

