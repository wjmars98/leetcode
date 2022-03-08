import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0) {
            return res;
        }

        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return res;
    }

    public void backTracking(String digits, String[] numStrings, int index) {
        if (index==digits.length()) {
            res.add(path.toString());
            return;
        }

        String str = numStrings[digits.charAt(index)-'0'];

        for (int i=0; i<str.length(); i++) {
            path.append(str.charAt(i));
            backTracking(digits, numStrings, index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
// @lc code=end

