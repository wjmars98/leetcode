/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        // 注意最小深度是根节点到最近的叶子节点的深度
        // 要注意分别节点左或者右有一个节点为空的情况
        return getMinDepth(root);
    }

    public int getMinDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left == null) return 1 + getMinDepth(root.right);
        if (root.right == null) return 1 + getMinDepth(root.left);
        return 1+Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }
}
// @lc code=end

