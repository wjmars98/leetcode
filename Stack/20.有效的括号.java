import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {                                                             
    Stack<Character> tmp;
    public boolean isValid(String s) {
        tmp = new Stack<>();
        int n = s.length();
        if(n==1) return false;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(') tmp.push(')');
            else if (s.charAt(i) == '{') tmp.push('}');
            else if (s.charAt(i) == '[') tmp.push(']');
            else {
                if(tmp.isEmpty() || tmp.peek() != s.charAt(i)) {
                    return false;
                } else {
                    tmp.pop();
                }
            }
        }
        if(tmp.isEmpty()) return true;
        else return false;
    }
}
// @lc code=end

