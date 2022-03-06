import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return bTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode bTree(int[] inorder, int inLeft, int inRight,
                            int[] postorder, int posLeft, int posRight) {
        if (inRight-inLeft<1) return null;
        if (inRight-inLeft==1) return new TreeNode(inorder[inLeft]);
        int rootVal = postorder[posRight-1];
        int rootIndex = 0;
        TreeNode root = new TreeNode(rootVal);
        for (int i=inLeft; i<inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = bTree(inorder, inLeft, rootIndex, postorder,posLeft, posLeft+rootIndex-inLeft);
        root.right = bTree(inorder, rootIndex+1, inRight, postorder, posLeft+rootIndex-inLeft, posRight-1);
        return root;
    }
}
// @lc code=end

