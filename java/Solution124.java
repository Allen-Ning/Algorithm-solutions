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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[] { Integer.MIN_VALUE };
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode node, int[] result) {
        if (node == null) return 0;

        int left = helper(node.left, result);
        int right = helper(node.right,result);

        int value = node.val + Math.max(0, left) + Math.max(0, right);
        result[0] = Math.max(result[0], value);
        int returnedValue = node.val + Math.max(0, Math.max(left, right));
        return returnedValue;
    }
}