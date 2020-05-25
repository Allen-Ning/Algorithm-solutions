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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }

    private TreeNode helper(TreeNode node, int limit, int value) {
        if (node == null) return null;

        int current = value + node.val;
        // trick -> return rule 1
        //          we have to do early return cos rule2 and rule1 are different (return rule1 needs to check againt limit)
        //          normally we do not need return rule1
        if (node.left == null && node.right == null) {
            if (current < limit) return null;
            return node;
        }

        node.left = helper(node.left, limit, current);
        node.right = helper(node.right, limit, current);

        // trick -> return rule 2;
        if (node.left == null && node.right == null) return null;
        return node;
    }
}

