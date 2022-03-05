/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        reverSubNode(root);
        return root;
    }

    public void reverSubNode(TreeNode root) {
        if (root==null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverSubNode(root.left);
        reverSubNode(root.right);
    }
}
// @lc code=end

