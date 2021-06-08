// 1 2 3 4 5 6 7 - good example 1

// 1 2 4 3 5 6 7 - bad exmaple 1
// 1 2 6 4 5 3 7 - bad exmaple 2
// 7 2 3 4 5 6 1 - bad exmaple 3

// Summary - binary tree inorder travel should  return ascending values (e.g. good example 1)
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

  TreeNode first = null;
  TreeNode second = null;
  TreeNode prev = null;
  public void recoverTree(TreeNode root) {
    helper(root);
    swop(first, second);
  }

  private void helper(TreeNode node) {
    if (node == null) return;

    helper(node.left);

    if (first == null && prev != null && prev.val >= node.val) {
      first = prev;
    }

    if (first != null && prev != null && prev.val >= node.val) {
      second = node;
    }
    prev = node;

    helper(node.right);
  }

  private void swop(TreeNode node1, TreeNode node2) {
    int temp = node1.val;
    node1.val = node2.val;
    node2.val = temp;
  }
}
