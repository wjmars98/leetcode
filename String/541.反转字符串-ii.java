/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    // 这题主要考察String、StringBuffer的调用与转化。
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start < length) {
            StringBuffer tmp = new StringBuffer();
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + 2*k > length) ? length : start + 2 * k;
            
            tmp.append(s.substring(start, firstK));
            res.append(tmp.reverse());
        
            if (firstK < secondK) {
                res.append(s.substring(firstK, secondK));
            }

            start += 2 * k;
        }
        return res.toString();
    }
}
// @lc code=end

