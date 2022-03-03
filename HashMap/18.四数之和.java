import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    // 三数和的变种问题，确定第一和第二两个数，多练习
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i-1]==nums[i]) {
                continue;
            }

            for (int j=i+1; j<nums.length; j++) {
                if (j>i+1 && nums[j-1]==nums[j]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

