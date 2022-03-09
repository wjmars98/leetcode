import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
 //   boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null) 
            return res;
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTracing(nums, used);
        return res;
    }

    public void backTracing(int[] nums, boolean[] used) {
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i]==nums[i-1] && used[i-1]==false)
                continue;
            if (used[i]==false) {
                path.add(nums[i]);
                used[i]=true;
                backTracing(nums, used);
                path.removeLast();
                used[i]=false;
            }
        }
    }

}
// @lc code=end

