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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);

        int[] result = new int[]{ 0 };
        helper(root, map, result, 0, targetSum);
        return result[0];
    }

    private void helper(TreeNode node, Map<Integer, Integer> map, int[] result, int sum, int targetSum) {
        if (node == null) return;

        sum += node.val;
        result[0] += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        helper(node.left, map, result, sum, targetSum);
        helper(node.right, map, result, sum, targetSum);
        map.put(sum, map.get(sum) - 1);
    }
}