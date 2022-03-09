import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null) return res;
        used = new boolean[nums.length];
        backTracing(nums);
        return res;
    }

    // 注意此处used的使用，每次返回上一层，used都会更新
    public void backTracing(int[] nums){
        if (nums.length==path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]==true) continue;
            used[i]=true;
            path.add(nums[i]);
            backTracing(nums);
            path.removeLast();
            used[i]=false;
        }
    }
}
// @lc code=end

