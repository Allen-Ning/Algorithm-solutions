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
        helper(results, targetSum, root, result, 0);
        return results;
    }

    private void helper(List<List<Integer>> results, int targetSum, TreeNode node, List<Integer> result, int currentSum) {
        if (node == null) return;

        result.add(node.val);
        if (node.left == null && node.right == null && currentSum + node.val == targetSum) results.add(new ArrayList(result));

        helper(results, targetSum, node.left, result, currentSum + node.val);
        helper(results, targetSum, node.right, result, currentSum + node.val);
        result.remove(result.size() - 1);
    }
}