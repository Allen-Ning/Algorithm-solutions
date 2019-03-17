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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int count = 0;
        TreeNode node = root;
        while(node != null) {
          stack.push(node);
          node = node.left;
        }

        while (!stack.isEmpty()) {
          node = stack.pop();
          count++;
          if (count == k) return node.val;
          node = node.right;
          while(node != null) {
            stack.push(node);
            node = node.left;
          }
        }
        return -1;
  }
}
