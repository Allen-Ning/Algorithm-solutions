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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /**
            1 -> find the node from root same as subRoot
            2 -> compare
            3 -> if same, return true
            4 -> if not same, return false
         */
        // trick -> root: [1, 1, 1] and subRoot: [1] -> return true
        if (subRoot == null) return false;
        return findSameSubRoot(root, subRoot);
    }

    private boolean findSameSubRoot(TreeNode node, TreeNode subRoot) {
        if (node == null) return false;
        if (helper(node, subRoot)) return true;

        return findSameSubRoot(node.left, subRoot) || findSameSubRoot(node.right, subRoot);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return helper(node1.left, node2.left) && helper(node1.right, node2.right);
    }
}