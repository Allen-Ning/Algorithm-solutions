/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p, new boolean[] { false });
    }

    private TreeNode helper(TreeNode node, TreeNode p, boolean[] isFound) {
        if (node == null) return null;

        TreeNode result1 = helper(node.left, p, isFound);
        if (result1 != null) return result1;

        // trick -> by doing inorder travelsal, first time will set isFound to true
        //          and then return the next visted node
        if (isFound[0]) return node;
        if (node == p) isFound[0] = true;

        TreeNode result2 = helper(node.right, p, isFound);
        if (result2 != null) return result2;
        return null;
    }
}
