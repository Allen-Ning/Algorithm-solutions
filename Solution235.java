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
        if (node.val > p.val && node.val > q.val) {
            return helper(node.left, p, q);
        } else if (node.val < p.val && node.val < q.val) {
            return helper(node.right, p, q);
        } else {
            return node;
        }
    }
}
