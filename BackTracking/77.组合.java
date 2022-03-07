import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    /*
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineTool(n, k, 1);
        return res;
    }

    public void combineTool(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex; i<= n-(k-path.size())+1; i++) {
            path.add(i);
            combineTool(n, k, i+1);
            path.removeLast();
        }
    }*/
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineTool(n, k, 1);
        return res;
    }

    public void combineTool(int n, int k, int startIndex) {
        if(path.size()==k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<=n-(k-path.size())+1; i++) {
            path.add(i);
            combineTool(n, k, i+1);
            path.removeLast();
        }
        return;
    }
}
// @lc code=end

