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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }

    private int helper(TreeNode node, int L, int R) {
        if (node == null) return 0;

        int value = 0;
        if (node.val < L) {
            value = helper(node.right, L, R);
        } else if (node.val > R) {
            value = helper(node.left, L, R);
        } else {
            value = node.val + helper(node.left, L, R) +  helper(node.right, L, R);
        }

        return value;
    }
}
