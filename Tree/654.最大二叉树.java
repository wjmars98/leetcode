/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return cMaxBinaryTree(nums, 0, nums.length);
    }

    public TreeNode cMaxBinaryTree(int[] nums, int left, int right) {
        int index=0, value=0;
        if (right-left < 1) return null;
        if (right-left == 1) return new TreeNode(nums[left]);
        for (int i=left; i<right; i++) {
            if (nums[i] > value) {
                value = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = cMaxBinaryTree(nums, left, index);
        root.right = cMaxBinaryTree(nums, index+1, right);
        return root;
    }
}
// @lc code=end

