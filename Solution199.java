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
  ArrayList<Integer> list;

  public List<Integer> rightSideView(TreeNode root) {
    list= new ArrayList();
    helper(root, 0);
    return list;
  }

  private void helper(TreeNode node, int level) {
    if (node == null) return;

    if (level == list.size()) { list.add(node.val); }

    helper(node.right, level + 1);
    helper(node.left, level + 1);
  }
}
