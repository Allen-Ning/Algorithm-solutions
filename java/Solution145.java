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
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();

        TreeNode node = root;
        if (node == null) return result;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                result.add(node.val);
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            node = node.left;
        }

        Collections.reverse(result);
        return result;
    }
}