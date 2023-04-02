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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> result = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);

                // trick -> do not add null into queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            results.add(result);
        }
        return results;
    }
}