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
    public int maxProduct(TreeNode root) {
        long mod = (int) 1e9 + 7;
        long sum = helper(root);
        long[] result = new long[] {0};
        helper2(root, sum, result);
        return (int) (result[0] % mod);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        return node.val + helper(node.left) + helper(node.right);
    }

    private long helper2(TreeNode node, long sum, long[] result) {
        if (node == null) return 0;

        long value = node.val + helper2(node.left, sum, result) + helper2(node.right, sum, result);
        long value2 = sum - value;
        result[0] = Math.max(result[0], (value * value2));
        return value;
    }
}