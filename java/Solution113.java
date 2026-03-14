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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> result = new ArrayList();
        helper(root, targetSum, result, results);
        return results;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> result, List<List<Integer>> results) {
        if (node == null) return;

        result.add(node.val);
        // trick -> check this leaf node to add result to avoid adding duplicated results
        // trick -> arraylist syntax to copy another arraylist
        if (node.left == null && node.right == null && targetSum == node.val) results.add(new ArrayList(result));

        helper(node.left, targetSum - node.val, result, results);
        helper(node.right, targetSum - node.val, result, results);

        // trick -> arraylist syntax to remove the last element
        result.remove(result.size() - 1);
    }
}