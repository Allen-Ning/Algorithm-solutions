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

    public int countNodes(TreeNode root) {
        return helper(root);
    }

    private int checkLeft(TreeNode node) {
        if (node == null) return 0;
        int height = checkLeft(node.left);
        return height + 1;
    }

    private int checkRight(TreeNode node) {
        if (node == null) return 0;
        int height = checkRight(node.right);
        return height + 1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkLeft(node);
        int rightHeight = checkRight(node);
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        } else {
            return helper(node.left) + helper(node.right) + 1;
        }
    }
}
