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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }

    private TreeNode helper(TreeNode node, int L, int R) {
        if (node == null) return null;

        if (node.val < L) {
            return helper(node.right, L, R);
        } else if (node.val > R) {
            return helper(node.left, L, R);
        } else {
            node.left = helper(node.left, L, R);
            node.right = helper(node.right, L, R);
            return node;
        }
    }
}