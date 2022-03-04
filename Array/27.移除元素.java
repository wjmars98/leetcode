/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length, count=0;
        int slowP=0, fastP=0;
        while (fastP != n) {
            if (nums[fastP] == val) {
                fastP++;
                count++;
            } else {
                nums[slowP++] = nums[fastP++];
            }
        }
        for (; slowP<n; slowP++) {
            nums[slowP++]=0;
        }
        return n-count;
    }
}
// @lc code=end

