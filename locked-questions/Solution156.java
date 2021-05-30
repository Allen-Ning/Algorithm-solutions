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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node;
        
        TreeNode root = helper(node.left);
        TreeNode left = node.left;
        TreeNode right = node.right;

        left.left = right;
        left.right = node;

        node.left = null;
        node.right = null;
        return root;
    }
    
}