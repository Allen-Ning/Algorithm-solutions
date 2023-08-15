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
    public boolean isBalanced(TreeNode root) {
        int result = helper(root);
        // trick -> special case when root is null, which should return true
        return result >= 0;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        if (left == -1) return left;
        int right = helper(node.right);
        if (right == -1) return right;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
