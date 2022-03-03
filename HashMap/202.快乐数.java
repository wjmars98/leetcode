import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    // set 用于快速查询是否存在的情况,可以用来判断循环
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<Integer>();
        while (n!=1 && !record.contains(n)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n==1;
    }

    private int getNextNum(int n) {
        int res = 0;
        int tmp = 0;
        while (n!=0) {
            tmp = n%10;
            n /= 10;
            res += tmp*tmp;
        }
        return res;
    }
}

// @lc code=end

