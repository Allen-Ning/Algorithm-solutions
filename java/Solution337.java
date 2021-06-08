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
  public int rob(TreeNode root) {
    int[] values = helper(root);
    return Math.max(values[0], values[1]);
  }

  private int[] helper(TreeNode node) {
    if (node == null) return new int[] {0, 0};

    int[] leftValues = helper(node.left);
    int[] rightValues = helper(node.right);
    return new int[] {
      node.val + leftValues[1] + rightValues[1],
      Math.max(leftValues[0], leftValues[1]) + Math.max(rightValues[0], rightValues[1])
    };
  }
}
