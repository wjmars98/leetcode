import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    // hashset的使用，注意HashSet、ArrayList 存放Object元素，
    // 所以存放Integer类，有一个元素转化的过程
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null|| nums1.length==0 || nums2 == null || 
                nums2.length==0) {
                    return new int[0];
                }
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for (int i:nums1) {
            s1.add(i);
        }
        for (int j:nums2) {
            if (s1.contains(j)) {
                s2.add(j);
            }
        }
        int[] res = new int[s2.size()];
        int index = 0;
        for (int i:s2) {
            res[index++] = i;
        }
        return res;
    }
}
// @lc code=end

