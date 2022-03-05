import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preTreeOrder(root, res);
        return res;
    }

    public void preTreeOrder(TreeNode root, List<Integer> res) {
        if (root==null) return;

        res.add(root.val);
        preTreeOrder(root.left, res);
        preTreeOrder(root.right, res);
        return;
        
    }
    */

    public List<Integer> preorderTraversal(TreeNode root) {
        // 遍历的化构造栈，左边先进入
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> tmpS = new Stack<>();
        if(root==null) return res;
        tmpS.push(root);
        while (!tmpS.isEmpty()) {
            TreeNode tmpN = tmpS.pop();
            res.add(tmpN.val);
            if (tmpN.right != null) tmpS.push(tmpN.right);
            if (tmpN.left != null) tmpS.push(tmpN.left);
        }
        return res;
    }
}
// @lc code=end

