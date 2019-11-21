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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        HashMap<TreeNode, Integer> map = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        map.put(root, 0);

        int result = 0;
        while (!queue.isEmpty()) {
          int size = queue.size();
          int start = 0;
          int end = 0;
          for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (i == 0) start = map.get(node);
            if (i == size - 1) end = map.get(node);

            int nodeIndex = map.get(node);
            if (node.left != null) {
              queue.offer(node.left);
              map.put(node.left, 2 * nodeIndex);
            }

            if (node.right != null) {
              queue.offer(node.right);
              map.put(node.right, 2 * nodeIndex + 1);
            }
          }
          result = Math.max(result, end - start + 1);
        }
        return result;
  }
}
