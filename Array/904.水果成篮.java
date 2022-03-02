/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    /*最小连续数组区间*/
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n==1) return 1;
        int type1=fruits[0], type2=-1; 
        int count1=1, count2=0, maxCount=1;
        int left=0, right=1;
        while(right<n) {
            if (type1 == fruits[right]) {
                count1++;
            } else if (type2==-1 || type2 == fruits[right]) {
                type2 = fruits[right];
                count2++;
            }  else {
                while(count1!=0&&count2!=0) {
                    if (fruits[left] == type1) {
                        count1--;
                    } else {
                        count2--;
                    }
                    left++;
                }
                if (count1==0) {
                    type1 = fruits[right];
                    count1 = 1;
                } else {
                    type2 = fruits[right];
                    count2 = 1;
                }
            }
            if (maxCount < count1 + count2) {
                maxCount = count1 + count2;
            }
            right++;
        }
        return maxCount;
    }
}
// @lc code=end

