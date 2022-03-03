import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    // 这题是HashMap的使用，利用两个for将A,B所有的组合结果放在表中
    // 然后再判定即可
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int tmp=0, res=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums1) {
            for (int j:nums2) {
                tmp = i + j;
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp)+1);
                }
                else {
                    map.put(tmp, 1);
                }
            }
        }

        for (int i:nums3) {
            for (int j:nums4) {
                tmp = i+j;
                if (map.containsKey(0 - tmp)) {
                    res += map.get(0-tmp);
                }
            }
        }
        return res;
    }
}
// @lc code=end

