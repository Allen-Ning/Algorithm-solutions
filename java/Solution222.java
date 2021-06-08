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
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        TreeNode left = node;
        TreeNode right = node;
        int height = 0;
        
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        
        if (left == null) {
            return (1 << height) - 1;
        } else {
            return helper(node.left) + helper(node.right) + 1;
        } 
    }   
}
