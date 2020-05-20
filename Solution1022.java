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
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> results = new ArrayList();
        int[] value = new int[1];
        helper(root, value, results);
        return value[0];
    }

    private TreeNode helper(TreeNode node, int[] value, List<Integer> results) {
        if (node == null) return null;

        results.add(node.val);
        TreeNode left = helper(node.left, value, results);
        TreeNode right = helper(node.right, value, results);
        if (left == null && right == null) value[0] += getValue(results);
        results.remove(results.size() - 1);
        return node;
    }

    private int getValue(List<Integer> results) {
        int value = 0;
        for (int i = 0; i < results.size(); i++) {
            value = value << 1 | results.get(i);
        }
        return value;
    }
}
