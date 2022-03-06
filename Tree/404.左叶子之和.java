import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    //  递归节点的值为左节点为叶子节点才有赋值
    /*
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        int midSum = 0;
        if (root.left != null && root.left.left==null && root.left.right==null) {
            midSum = root.left.val;
        }
        int sum = leftSum + rightSum + midSum;
        return sum;
    }
    */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        Stack<TreeNode> Nstack = new Stack<>();
        Nstack.add(root);
        int res = 0;
        while(!Nstack.isEmpty()){
            TreeNode tn = Nstack.pop();
            if (tn.left!=null && tn.left.left==null && tn.left.right==null) {
                res += tn.left.val;
            }
            if (tn.right != null) Nstack.add(tn.right);
            if (tn.left != null) Nstack.add(tn.left);
        }
        return res;
    }
}
// @lc code=end

