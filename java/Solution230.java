/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode() {}
 *   TreeNode(int val) { this.val = val; }
 *   TreeNode(int val, TreeNode left, TreeNode right) {
 *     this.val = val;
 *     this.left = left;
 *     this.right = right;
 *   }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        /**
         * trick -> An in-order traversal of a binary search tree (BST) returns all the
         * node values in ascending sorted order
         */
        int[] result = new int[] { 1, -1 };
        helper(root, result, k);
        return result[1];
    }

    private void helper(TreeNode node, int[] result, int k) {
        if (node == null)
            return;

        helper(node.left, result, k);
        if (result[0] == k)
            result[1] = node.val;
        result[0] += 1;

        helper(node.right, result, k);
    }
}
