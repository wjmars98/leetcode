import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    Stack<Character> tmp;
    Stack<Character> tmp2;
    public String removeDuplicates(String s) {
        tmp = new Stack<>();
        tmp2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if(tmp.isEmpty()) tmp.push(s.charAt(i));
            else if (tmp.peek() == s.charAt(i)) tmp.pop();
            else tmp.push(s.charAt(i));
        }
        while (!tmp.isEmpty()){
            tmp2.push(tmp.pop());
        }
        while (!tmp2.isEmpty()) {
            res.append(tmp2.pop());
        }
        return res.toString();
    }
}
// @lc code=end

