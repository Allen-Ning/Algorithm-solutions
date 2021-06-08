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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> set = new HashSet();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) return false;

        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return helper(node.left, k, set) || helper(node.right, k, set);
    }
}
