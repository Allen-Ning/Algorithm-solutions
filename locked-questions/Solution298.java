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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        int[] result = new int[] { 1 };
        helper(root, result, null, 1);
        return result[0];
    }

    private void helper(TreeNode node, int[] result, TreeNode parent, int level) {
        if (node == null) return;

        if (parent != null && parent.val + 1 == node.val) {
            level += 1;
        } else {
            level = 1;
        }

        result[0] = Math.max(result[0], level);
        helper(node.left, result, node, level);
        helper(node.right, result, node, level);
    }
}
