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
    public int longestZigZag(TreeNode root) {
        int[] result = new int[] {0};
        helper(root.left, true, result);
        helper(root.right, false, result);
        return result[0];
    }

    private int helper(TreeNode node, boolean isLeft, int[] result) {
        if (node == null) return 0;

        int leftValue = helper(node.left, true, result);
        int rightValue = helper(node.right, false, result);

        int value = (isLeft ? rightValue : leftValue) + 1;
        result[0] = Math.max(result[0], value);

        return value; 
    }
}