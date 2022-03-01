/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    /*
    利用二分法不断逼近左右边界。各个边界应该分开来找。
    边界的值不包括target
    */
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1,-1};
        } 
        if (rightBorder - leftBorder > 1) {
            return new int[] {leftBorder+1, rightBorder-1};
        }
        return new int[]{-1,-1};
        
    }

    public int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + ((right-left)/2);
            if (nums[middle]  > target) { // 注意此时没有等于
                right = middle - 1;
            }
            else {
                // nums[middle] == target的时候更新left
                left = middle + 1; 
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + ((right-left)/2);
            if (nums[middle] >= target) {
                // nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
}
// @lc code=end

