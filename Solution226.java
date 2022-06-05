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
        return helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) return null;

        TreeNode left = helper(node.right);
        TreeNode right = helper(node.left);

        node.left = left;
        node.right = right;
        return node;
    }
}