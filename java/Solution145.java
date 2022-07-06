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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList();
        Stack<TreeNode> stack = new Stack();

        TreeNode node = root;
        if (node == null) return result;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                // trick -> add to the head of the linkedlist
                result.add(0, node.val);
                stack.add(node);
                // trick -> visit the right child of the node first
                node = node.right;
            }

            node = stack.pop();
            node = node.left;
        }
        return result;
    }
}