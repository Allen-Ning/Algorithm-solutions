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
    public int distributeCoins(TreeNode root) {
        int[] result = new int[] {0};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode node, int[] result) {
        if (node == null) return 0;
        
        int left = helper(node.left, result);
        int right = helper(node.right, result);
        
        result[0] += Math.abs(left) + Math.abs(right);
        return left + right + node.val - 1;
    }
}
