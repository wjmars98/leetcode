/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int col=0, raw=0, num=n*n, directionIndex=0;
        boolean[][] visited = new boolean[n][n];
        int[][] res = new int[n][n];
        int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
        res[raw][col] = 1;
        for (int i=1; i<num; i++) {
            visited[raw][col] = true;
            int nextRaw = raw + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if (nextRaw<0 || nextRaw>=n || nextCol<0 || nextCol >=n || 
                visited[nextRaw][nextCol]==true) {
                    directionIndex = (directionIndex+1)%4;
                }
            raw = raw + direction[directionIndex][0];
            col = col + direction[directionIndex][1];
            res[raw][col] = i+1;
        }
        return res;
    }
}
// @lc code=end

