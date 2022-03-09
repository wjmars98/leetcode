import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums==null) {
            res.add(new ArrayList<>());
            return res;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracing(nums, 0);
        return res;
    }

    public void backTracing(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex==nums.length) {
            return;
        }

        for (int i=startIndex; i<nums.length; i++) {
            if (i>startIndex && nums[i]==nums[i-1]) {
 //               path.add(nums[i]);
                continue;
            }
            path.add(nums[i]);
            // used[i]=true;
            backTracing(nums, i+1);
            path.removeLast();
            // used[i] = false;
        }
    }
}
// @lc code=end

