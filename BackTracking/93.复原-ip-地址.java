import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        backTracing(s, 0, 0);
        return res;
    }

    public void backTracing(String s, int startIndex, int nodeNums) {
        if (nodeNums==3) {
            if (ifValid(s,startIndex, s.length()-1)) {
                res.add(s);
            }
            return;
        }

        for (int i=startIndex; i<s.length(); i++) {
            if(ifValid(s, startIndex, i)) {
                s = s.substring(0, i+1) + '.' + s.substring(i+1);
                nodeNums++;
                backTracing(s, i+2, nodeNums);
                nodeNums--;
                s = s.substring(0, i+1) + s.substring(i+2);
            } else {
                break;
            }
        }
    }

    public boolean ifValid(String s, int start, int end) {
        String str = s.substring(start, end+1);
        int num=0;
        if (start > end) return false;
        if (s.charAt(start)=='0'&& end!=start) return false;
        for (int i=0; i<str.length(); i++) {
            num = 10*num + str.charAt(i)-'0';
        }
        if (num>255) return false;
        return true;
    }
}
// @lc code=end

