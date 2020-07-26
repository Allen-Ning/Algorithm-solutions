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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }

    private TreeNode helper(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;

        TreeNode left = helper(original.left, cloned.left, target);
        if (left != null) return left;
        TreeNode right = helper(original.right, cloned.right, target);
        if (right != null) return right;
        return null;
    }
}