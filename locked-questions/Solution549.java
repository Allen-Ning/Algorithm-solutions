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
    public int longestConsecutive2(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }

    private int[] helper(TreeNode node, int[] result) {
        // num of increasement, decreasement
        if (node == null) return new int[] {0, 0};

        int[] left = helper(node.left, result);
        int[] right = helper(node.right, result);

        if (node.left != null) {
            if (node.left.val + 1 != node.val) left[0] = 0;
            if (node.left.val - 1 != node.val) left[1] = 0;
        }

        if (node.right != null) {
            if (node.right.val + 1 != node.val) right[0] = 0;
            if (node.right.val - 1 != node.val) right[1] = 0;
        }

        result[0] = Math.max(result[0], Math.max(left[1] + right[0], left[0] + right[1]) + 1);
        return new int[] { Math.max(left[0], right[0]) + 1, Math.max(left[1], right[1]) + 1};
    }
}