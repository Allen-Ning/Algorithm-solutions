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
    public int maxAncestorDiff(TreeNode root) {
        int[] result = new int[]{0};
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE, result);
        return result[0];
    }

    private void helper(TreeNode node, int low, int high, int[] result) {
        if (node == null) return;
        low = Math.min(low, node.val);
        high = Math.max(high, node.val);
        result[0] = Math.max(result[0], high - low);
        helper(node.left, low, high, result);
        helper(node.right, low, high, result);
        return;
    }
}
