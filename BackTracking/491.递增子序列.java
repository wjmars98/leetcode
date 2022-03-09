import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return res;
    }

    public void backTracing(int[] nums, int startIndex) {
        if (path.size()>1) {
            res.add(new ArrayList<>(path));
        }
        // used数组针对的是单层的元素是否被重复使用
        // 每一层的used都会被重置
        boolean[] used = new boolean[201];
        for (int i=startIndex; i<nums.length; i++) {
            if (!path.isEmpty() && nums[i]<path.get(path.size()-1)||
                used[nums[i]+100]==true){
                    continue;
                }
            used[nums[i]+100]=true;
            path.add(nums[i]);
            backTracing(nums, i+1);
            path.removeLast();
        }
    }
}
// @lc code=end

