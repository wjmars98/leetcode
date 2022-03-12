/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            count += nums[i];
            if (count > res) {
                res = count;
            }
            if (count<0) count = 0;
        }
        return res;
    }
}
// @lc code=end

