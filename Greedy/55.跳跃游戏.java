import java.nio.charset.CoderResult;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    // 计算跳跃覆盖的最大范围
    public boolean canJump(int[] nums) {
        if (nums.length == 1)  return true;

        int cover = 0;
        for (int i=0; i<=cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

