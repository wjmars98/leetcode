import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= 0 || k==0) break;
            nums[i] = -nums[i];
            k--;
        }
        Arrays.sort(nums);
        nums[0] = (int)Math.pow(-1, k%2) *nums[0];
        for (int i=0; i<nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
// @lc code=end

