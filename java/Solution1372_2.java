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
        helper(root, result);
        return result[0];
    }

    private int[] helper(TreeNode node, int[] result) {
        if (node == null) return new int[] {-1, -1};

        int[] leftValues = helper(node.left, result);
        int[] rightValues = helper(node.right, result);
        result[0] = Math.max(result[0], Math.max(leftValues[1], rightValues[0]) + 1);

        return new int[] {leftValues[1] + 1, rightValues[0] + 1};
    }
}