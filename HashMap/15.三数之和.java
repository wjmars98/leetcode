import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    // 这道题稍显复杂，需要思考查重的问题，如果用Hashmap过程会比较繁琐
    // 所以采用显排序，然后再确定一个值，利用用双指针方法求解。
    // 需要注意Array，List，ArrayList关联
    // Array是内存空间连续的数组，List是ArrayList的泛型，List要确定存储
    // 内容的数据类型，ArrayList的数据类型是Object，所以
    // List<int> res = ArrayList<>();确定了res这个ArrayList数据类型为int
        
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++ ){
            if(nums[i] > 0) {
                return res;
            }

            if (i >0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[left]==nums[left+1]) {
                        left++;
                    }
                    while (right > left && nums[right]==nums[right-1]) {
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

