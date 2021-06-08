/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int max = 0;
        int result = 1;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            int current = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                current += node.val;
            }

            if (current > max) {
                max = current;
                result = level;
            }
            level++;
        }
        return result;
    }
}
