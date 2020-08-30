/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        int[] result = new int[] { 0 };
        helper(root, target, result);
        return result[0];
    }

    private void helper(TreeNode node, double target, int[] result) {
        if (node == null) return;

        if (Math.abs(node.val - target) < Math.abs(result[0] - target)) result[0] = node.val;
        if (target > node.val) {
            helper(node.right, target, result);
        } else {
            helper(node.left, target, result);
        }
    }
}