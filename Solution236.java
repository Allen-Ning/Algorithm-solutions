/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == p || node == q || node == null) return node;

        TreeNode node1 = helper(node.left, p, q);
        TreeNode node2 = helper(node.right, p, q);

        if (node1 != null && node2 != null) {
            return node;
        }
        return node1 == null ? node2 : node1;
    }
}
