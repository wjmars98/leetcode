import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return robAction(root, map);
    }

    public int robAction(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        // 第一种情况，取root节点及其孙子节点，儿子节点不取
        int sum = root.val;
        if (root.left != null) {
            sum += robAction(root.left.left, map) + robAction(root.left.right, map);
        }
        if (root.right != null) {
            sum += robAction(root.right.left, map) + robAction(root.right.right, map);
        }
        // 第二种情况，root节点及其孙子不取，取其儿子节点
        // 结果为两种情况的最大值
        int res = Math.max(robAction(root.left, map) + robAction(root.right, map), sum);
        map.put(root, res);
        return res;
    }


}
// @lc code=end

