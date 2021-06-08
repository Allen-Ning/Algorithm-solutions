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
    public int minDiffInBST(TreeNode root) {
        int[] result = new int[] { Integer.MAX_VALUE };
        helper(root, result, new TreeNode[] { null });
        return result[0];
    }

    private void helper(TreeNode node, int[] result, TreeNode[] lastVisit) {
        if (node == null) return;

        helper(node.left, result, lastVisit);
        // trick -> use bst inorder will increase value
        //          lastVisit[0] means the last visited node
        if (lastVisit[0] != null) result[0] = Math.min(result[0], node.val - lastVisit[0].val);
        lastVisit[0] = node;
        helper(node.right, result, lastVisit);
    }
}