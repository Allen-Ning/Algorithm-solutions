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

    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        helper(node.right);
        helper(node.left);
        node.left = null;
        node.right = pre;
        pre = node;
    }
}
