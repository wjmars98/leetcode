import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combianTool(k, n, 1, 0);
        return res;
    }

    public void combianTool(int k, int n, int startIndex, int sum) {
        if (sum>n) {
            return;
        }

        if (path.size()==k) {
            if (sum==n) res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<=9-(k-path.size())+1; i++) {
            path.add(i);
            sum = sum + i;
            combianTool(k, n, i+1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
// @lc code=end

