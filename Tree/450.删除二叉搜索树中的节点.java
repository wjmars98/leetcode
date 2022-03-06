import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    // 删除BFT中的指点节点，关键在
    // 1. 对对应节点子节点的情况分类讨论
    // 2. 将目标节点的左子树，放在右子树的最左节点
    public TreeNode deleteNode(TreeNode root, int key) {
        return delTreeNode(root, key);
    }
    public TreeNode delTreeNode(TreeNode root, int key) {
        if (root==null ) return null;
        if (root.val > key) {
            root.left = delTreeNode(root.left, key);
        } else if (root.val < key) {
            root.right = delTreeNode(root.right, key);
        } else {
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = root.left;
            return root.right;
        }
        return root;
    }
}
// @lc code=end

