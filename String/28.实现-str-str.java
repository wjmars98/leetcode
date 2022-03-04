/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    // 使用kmp算法区求解
    // 1. getNext 构建前缀表，前缀表主要是找最长相等前后缀
    // 2. 获得前缀表后，字符串和字串进行比对
    // 3. 注意不相等判定为while循环，由于j初始化为0，所以回退要找next[j-1]
    public void getNext(int[] next, String s){
        int j = 0;
        next[0] = j;
        for (int i=1; i<s.length(); i++){
            while(j>0  && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i=0; i<haystack.length(); i++) {
            while(j>0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j==needle.length()) {
                return i-needle.length()+1;
            }
        }
        return -1;

    }
}
// @lc code=end

