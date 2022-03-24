/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null)
            return 0;
        if (nums.length==1)
            return nums[0];
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i=1; i<n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
// @lc code=end

