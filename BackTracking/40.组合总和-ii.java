import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null) return res;
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex; i<candidates.length && sum + candidates[i] <= target; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backTracking(candidates, target, sum+candidates[i], i+1);
            path.removeLast();
            while (i<candidates.length-1 && candidates[i+1]==candidates[i]) i++;
        }
    }
}
// @lc code=end

