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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0, false);
    }

    private int helper(TreeNode node, int sum, boolean isLeft) {
        if (node == null) return 0;

        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }
        return helper(node.left, sum, true) + helper(node.right, sum, false);
    }
}
