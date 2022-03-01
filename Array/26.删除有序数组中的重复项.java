/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        /*
            数组采用双指针的方法
        */
        int n = nums.length;
        int left=0, right=1;
        for (int i=0; i<n-1; i++) {
            /*
                注意双指针替换过程
                右指针每次循环向后一步，左右指针元素相同时替换
                左指针对应元素
            */
            if(nums[left] != nums[right]) {
                nums[left+1] = nums[right];
                left++;
            }
            right++;
        }
        return left+1;
    }
}
// @lc code=end

