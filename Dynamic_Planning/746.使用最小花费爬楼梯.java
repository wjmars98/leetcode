/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    // 动态规划五个步骤
    // 1. 确定动态规划数组
    // 2. 确定转移函数
    // 3. 数组初始化
    // 4. 确定遍历顺序
    // 5. 举例推导dp数组
    public int minCostClimbingStairs(int[] cost) {
        if (cost==null || cost.length==0) return 0;
        if (cost.length==1) return cost[0];

        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
}
// @lc code=end

