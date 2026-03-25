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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        boolean flip = false;
        while (queue.size() > 0) {
            int size = queue.size();
            // trick -> LinkedList allow to addFirst and addList with o(1)
            // trick -> 1. reverse the order of the result at odd levels (1, 3, 5...) if root is level 0
            //          2. use the generic approach to to level traversal
            List<Integer> result = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                // trick -> no need to change the traversal order,
                //          and only need to change the the order of result
                if (flip) {
                    result.addFirst(node.val);
                } else {
                    result.addLast(node.val);
                }
            }
            flip = !flip;
            results.add(result);
        }
        return results;
    }
}