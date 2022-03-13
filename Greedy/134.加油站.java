/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i=0; i<gas.length; i++) {
            curSum += gas[i] - cost[i]; // 注意curSum也要叠加
            totalSum += gas[i] - cost[i];
            if (curSum < 0 ) {
                start = (i+1)%gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }
}
// @lc code=end

