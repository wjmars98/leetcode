/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    // 1. dp数组及其下标含义: dp[i] 表示1~i个节点构成的搜索二叉树数目
    // 2. 确定递推公式：dp[i] 为1-i个节点轮流为头节点，左右搜索树数乘积
    //      dp[i] += dp[j-1]*dp[i-j]; j表示头节点位置
    // 3. 初始赋值：dp[0] = 1 空子树也算树 ; dp[1]=1；
    // 4. 确定便利顺序
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

