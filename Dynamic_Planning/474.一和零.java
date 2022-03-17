/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 1. dp[m][n]数组为表示目标m个0，n个1最大的字符串个数
        // 2. 递推公式: dp[m][n] = max(dp[m][n], dp[m-zeroNum][n-oneNum]+1)
        //      表示对比当前字符串是否放入的情况
        // 3. 初始化: dp[0][0] = 0;
        // 这题是一道0-1背包问题，关键在于什么是背包（0，1目标书），
        // 什么是物品：字符串
        int[][] dp = new int[m+1][n+1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch=='0') zeroNum++;
                else oneNum++;
            }

            for (int i=m; i>=zeroNum; i--) {
                for (int j=n; j>=oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
                }
            }
        }
        return dp[m][n]; 
    }
}
// @lc code=end

