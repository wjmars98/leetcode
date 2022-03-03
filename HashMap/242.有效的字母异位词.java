/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    // hashmap部分注意toCharArray的使用
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c:s.toCharArray()){
            record[c - 'a'] += 1;
        }

        for (char c:t.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i:record) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

