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
    public void flatten(TreeNode root) {
        helper(root, null);
    }

    private TreeNode helper(TreeNode node, TreeNode prev) {
        if (node == null) return prev;

        TreeNode right = helper(node.right, prev);
        TreeNode left = helper(node.left, right);

        node.left = null;
        node.right = left;
        return node;
    }
}