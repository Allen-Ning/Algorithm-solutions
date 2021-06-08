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
    public int sumEvenGrandparent(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }

    private void helper(TreeNode node, int[] result) {
        if (node == null) return;

        if (node.val % 2 == 0) {
            if (node.left != null && node.left.left != null) result[0] += node.left.left.val;
            if (node.left != null && node.left.right != null) result[0] += node.left.right.val;
            if (node.right != null && node.right.left != null) result[0] += node.right.left.val;
            if (node.right != null && node.right.right != null) result[0] += node.right.right.val;
        }
        helper(node.left, result);
        helper(node.right, result);
    }
}
