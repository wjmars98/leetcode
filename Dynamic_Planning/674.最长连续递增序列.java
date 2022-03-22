/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    // 注意初始化
    public int findLengthOfLCIS(int[] nums) {
        if (nums==null)
            return 0;
        if (nums.length <= 1)
            return nums.length;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i<n; i++) {
            if (nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1;
            else
                dp[i] = 1;
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }
}
// @lc code=end

