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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        helper(root, results);
        return results;
    }

    private int helper(TreeNode node, List<List<Integer>> results) {
        if (node == null) return -1;

        int index = Math.max(helper(node.left, results), helper(node.right, results)) + 1;
        List<Integer> result;
        if (index < results.size()) {
            result = results.get(index);
            result.add(node.val);
        } else {
            result = new ArrayList();
            result.add(node.val);
            results.add(result);
        }
        return index;
    }
}