/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        // 分发糖果，需要从左往右比较右边比左大
        // 再从右往左比较右比左大
        if (ratings.length==0) return 0;
        if (ratings.length==1) return 1;
        int res = 0;
        int[] candyVal = new int[ratings.length];
        for (int i=0; i<ratings.length; i++) candyVal[i]=1;
        for (int i=1; i<ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candyVal[i] = candyVal[i-1]+1;
            }
        }
        for (int i=ratings.length-1; i>0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candyVal[i-1] = Math.max(candyVal[i-1], candyVal[i]+1);
            }
        }
        for (int i=0; i<ratings.length; i++) res += candyVal[i];
        return res;
    }
}
// @lc code=end

