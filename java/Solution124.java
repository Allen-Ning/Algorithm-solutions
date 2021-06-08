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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int total = node.val;
        if (left > 0) total += left;
        if (right > 0) total += right;
        max = Math.max(total, max);
        return node.val + Math.max(0, Math.max(left, right));
    }
}
