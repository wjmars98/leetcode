import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        posOrderNode(root, res);
        return res;
    }

    public void posOrderNode(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null)  posOrderNode(root.left, res);
        if (root.right != null) posOrderNode(root.right, res);
        res.add(root.val);
    }
}
// @lc code=end

