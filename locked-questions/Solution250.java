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
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        int[] result = new int[] { 0 };
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        helper(root, dummy, result);
        return result[0];
    }

    private int helper(TreeNode node, TreeNode parent, int[] result) {
        if (node == null) return parent.val;

        int left = helper(node.left, node, result);
        int right = helper(node.right, node, result);
        if (left == right && node.val == left) {
            result[0] += 1;
            return node.val;
        } else {
            return parent.val - 1;
        }
    }
}