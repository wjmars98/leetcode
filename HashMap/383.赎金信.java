/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    // 这题需要注意的是数组与Map的选择，由于此题26数组大小知晓，数组
    // 更为简单快速，Map需要维护红黑树哈希表，数据量大的时候消耗大
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magSet = new int[26];
        for (char c:magazine.toCharArray()) {
            magSet[c-'a']++;
        }

        for (char c:ransomNote.toCharArray()) {
            magSet[c - 'a']--;
            if (magSet[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

