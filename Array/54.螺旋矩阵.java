import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = matrix[0].length, h = matrix.length;
        int num = l * h;
        List<Integer> res = new ArrayList<Integer>();
        
        // 采用模拟的方法

        int raw = 0, col = 0;
        int[][] direction = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        boolean[][] visited = new boolean[h][l];
        for (int i=0; i<num; i++) {
            res.add(matrix[raw][col]);
            visited[raw][col] = true;
            int nextRaw = raw + direction[directIndex][0];
            int nextCol = col + direction[directIndex][1];
            if (nextRaw<0 || nextRaw >= h || nextCol<0 || nextCol>=l || visited[nextRaw][nextCol]){
                directIndex = (directIndex+1) % 4;
            }
            raw = raw + direction[directIndex][0];
            col = col + direction[directIndex][1];
        }

        return res;
    }
}
// @lc code=end

