/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n==1)return;
        int left = 0, right = 0;
        for (int i=0; i<n; i++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right++];
            } else {
                right++;
            }
        }
        for (int i=left; i<n; i++) {
            nums[i]=0;
        }
        return;
    }
}
// @lc code=end

