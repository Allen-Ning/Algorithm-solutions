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
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return null;
    helper(root, val);
    return root;
  }

  private TreeNode helper(TreeNode node, int val) {
    if (node == null) {
      TreeNode newNode = new TreeNode(val);
      return newNode;
    }

    if (val > node.val) {
        TreeNode addeNode = helper(node.right, val);
        if (addeNode != null) { node.right = addeNode; }
    } else {
        TreeNode addeNode = helper(node.left, val);
        if (addeNode != null) { node.left = addeNode; }
    }
    return null;
  }
}
