import java.security.PublicKey;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 递归的写法，利用前序遍历方法，注意出口以及单层逻辑
    int MAX_LEN = 0;
    int RES_VALUE = 0;
    public int findBottomLeftValue(TreeNode root) {
        RES_VALUE = root.val;
        curLeftNodeValue(root, MAX_LEN);
        return RES_VALUE;
    }
    public void curLeftNodeValue(TreeNode root, int len) {
        if (root == null) return;
        if (len>MAX_LEN && root.left==null && root.right==null) {
            RES_VALUE = root.val;
            MAX_LEN=len;
        }
        if (root.left != null) curLeftNodeValue(root.left, len+1);
        if (root.right != null) curLeftNodeValue(root.right, len+1);
    }
}
// @lc code=end

