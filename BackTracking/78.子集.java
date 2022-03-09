import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res  = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null) {
            res.add(new ArrayList<>());
            return res;
        }
        backTracing(nums, 0);
        return res;
    }

    public void backTracing(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i=startIndex; i<nums.length; i++) {
            path.add(nums[i]);
            // startIndex为当前递归的左切割线，i为右切割线
            backTracing(nums, i+1);
            path.removeLast();
        }
    }
}
// @lc code=end

