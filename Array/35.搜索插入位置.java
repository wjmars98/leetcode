/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int middle = left + ((right-left)/2);
            if (target < nums[middle]) {
                right = middle-1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right+1;
        /*
            利用二分的方法（左闭右闭），在时间复杂度logn条件找到位置
            主要分为四种情况：
            1. 目标值在数组左侧: [0,-1]
            2. 目标值在存在于数组中: middle
            3. 目标值不存在与数组二位置在数组中:right+1
            4. 目标值在数组外:right+1
        */
    }
}
// @lc code=end

