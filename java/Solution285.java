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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p);
    }

    // trick -> 1. travel right as much as it can
    //          2. pass the p node
    //          3. travel the left as much as it can
    private TreeNode helper(TreeNode node, TreeNode p) {
        if (node == null) return null;

        if (node.val <= p.val) {
            return helper(node.right, p);
        } else {
            TreeNode left = helper(node.left, p);
            // trick -> small trick to get the most left one
            return left == null ? node : left;
        }
    }
}