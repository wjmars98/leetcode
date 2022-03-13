/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // 不断记录当前最远覆盖距离以及走一步能覆盖的最远距离
        // 当走到当前最远距离的时候，步数加一，更改最远距离
        int res = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i=0; i<nums.length-1; i++) {
            nextDistance = Math.max(i+nums[i], nextDistance);
            if (i==curDistance) {
                curDistance = nextDistance;
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

