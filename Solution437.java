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
    int counter;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        helper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return counter;
    }

    private void helper(TreeNode node, int sum, int current) {
        if (node == null) return;
        
        int currentValue = current + node.val;
        if (currentValue == sum) counter++;
        helper(node.left, sum, currentValue);
        helper(node.right, sum, currentValue);
    }
}
