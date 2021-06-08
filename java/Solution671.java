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
    long result;
    long rootValue;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        this.result = Long.MAX_VALUE;
        this.rootValue = root.val;
        helper(root);
        return result == Long.MAX_VALUE ? -1 : (int) result;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        if (node.val - rootValue > 0) {
            if (node.val - rootValue < result - rootValue) result = node.val;
            return;
        }

        if (node.val == rootValue) {
            helper(node.left);
            helper(node.right);
        }
    }
}
