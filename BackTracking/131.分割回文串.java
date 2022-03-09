import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if(s=="") return res;
        backTracing(s, 0);
        return res;
    }

    public void backTracing(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i=startIndex; i<s.length(); i++) {
            String str = s.substring(startIndex, i+1);
//            if (str=="") continue;
            if (ifPalindrome(str)) {
                path.add(str);
            } else {
                continue;
            }
            backTracing(s, i+1);
            path.removeLast();
        }
    }

    public boolean ifPalindrome(String s) {
        int end = s.length()-1;
        boolean res = true;
        for (int i=0, j=end; i<=end; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return res;
    }
}
// @lc code=end

