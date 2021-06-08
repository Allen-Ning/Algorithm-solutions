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
    public boolean isValidBST(TreeNode root) {
      helper(node, null, null);
    }

    private boolean helper(TreeNode node, int min, int max) {
      if (node == null) return true;
      if ((max != null && node.val >= max ) || (min != null && node.val <= min)) return false;
      return helper(node.left, min, node.val) && helper(node.right, node.val, min);
    }
}
