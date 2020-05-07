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
    public int longestUnivaluePath(TreeNode root) {
        int[] result = new int[] { 0 };
        helper(root, result);
        return result[0];
    }

    private int[] helper(TreeNode node, int[] result) {
        if (node == null) return null;

        int[] left = helper(node.left, result);
        int[] right = helper(node.right, result);

        int added = 0;
        int returnedMax = 0;
        if (left != null && node.val == left[0]) {
            added += left[1];
            returnedMax = Math.max(returnedMax, left[1]);
        }
        if (right != null && node.val == right[0]) {
            added += right[1];
            returnedMax = Math.max(returnedMax, right[1]);
        }

        result[0] = Math.max(result[0], added);
        return new int[] {node.val, 1 + returnedMax};
    }
}
