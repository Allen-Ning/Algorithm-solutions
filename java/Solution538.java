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
    public TreeNode convertBST(TreeNode root) {
        // trick -> find the right pattern to accumulate base by observation examples
        helper(root, new int[] {0});
        return root;
    }
    
    private void helper(TreeNode node, int[] base) {
        if (node == null) return;
        
        helper(node.right, base);
        node.val += base[0];
        base[0] = node.val;
        helper(node.left, base);
    }
}
