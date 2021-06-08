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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return helper(root, val);
    }

    private TreeNode helper(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);

        TreeNode current = node;
        if (val > current.val) {
            current = new TreeNode(val);
            current.left = node;
        } else {
            current.right = helper(current.right, val);
        }
        return current;
    }
}
