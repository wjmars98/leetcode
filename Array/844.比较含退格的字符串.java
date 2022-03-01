/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int ls = s.length()-1, lt = t.length()-1;
        int skipS = 0, skipT=0;
        while (ls>=0 || lt>=0) {
            while(ls >= 0) {
                if(s.charAt(ls)=='#'){
                    skipS++;
                    ls--;
                } else if (skipS>0){
                    skipS--;
                    ls--;
                } else {
                    break;
                }
            }
            while(lt >= 0) {
                if(t.charAt(lt)=='#'){
                    skipT++;
                    lt--;
                } else if (skipT>0) {
                    skipT--;
                    lt--;
                } else {
                    break;
                }
            }
            if(ls>=0 && lt>=0) {
                if(s.charAt(ls) != t.charAt(lt)) {
                    return false;
                }
            } else {
                if (ls>=0 || lt>=0) {
                    return false;
                }
            }
            ls--;
            lt--;
        }
        return true;
    }
}
// @lc code=end

