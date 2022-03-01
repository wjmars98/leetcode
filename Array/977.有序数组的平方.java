/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    /*
    数组问题多用双指针去解决，需要注意边界的判定情况
    */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length,count=0;
        int left = 0, right = n-1;
        int[] res = new int[n];
        while(left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])){
                res[n-count-1] = nums[right]*nums[right];
                right--;
            } else {
                res[n-count-1] = nums[left]*nums[left];
                left++;
            }
            count++;
        }
        return res;
    }
}
// @lc code=end

