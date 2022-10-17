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
            LinkedList<Integer> levelList = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // trick -> linkedlist addFirst, addLast is o(1)
                if (level % 2 == 0) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
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