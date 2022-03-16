/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    // 有很多细节的地方需要注意
    public boolean canPartition(int[] nums) {
        // target 是背包容量，也是价值
        int n = nums.length;
        int sum = 0;
        for (int num:nums) sum += num;
        if (sum%2==1) return false;
        int target = sum/2;
        int[] dp = new int[target+1];
        for (int i=0; i<n; i++) {
            for (int j=target; j>=nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target] == target;
    }
}
// @lc code=end

