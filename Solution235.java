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
        if (node == null) return node;
        if (node.val > p.val && node.val < q.val) return node;
        if (node.val > q.val && node.val < p.val) return node;
        if (node.val == p.val) return p;
        if (node.val == q.val) return q;

        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);

        return left == null ? right : left;
    }
}
