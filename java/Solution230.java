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
    public int kthSmallest(TreeNode root, int k) {
        /**
            dfs

            in-order traversal
        */
        List<Integer> result = new ArrayList();
        helper(result, root, k);
        return result.get(k - 1);
    }

    private void helper(List<Integer> result, TreeNode node, int k) {
        if (node == null) return;
        if (result.size() >= k) return;

        helper(result, node.left, k);
        result.add(node.val);
        helper(result, node.right, k);
    }
}