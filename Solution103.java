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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList();
    ArrayList<List<Integer>> result = new ArrayList();
    if (root == null) return result;
    queue.add(root);
    int level = 0;
    while (queue.size() > 0) {
      int size = queue.size();
      ArrayList<Integer> levelList = new ArrayList();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pop();
        if (level % 2 == 0) {
          levelList.add(node.val);
        } else {
          levelList.add(0, node.val);
        }
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      level += 1;
      result.add(levelList);
    }
    return result;
  }
}
