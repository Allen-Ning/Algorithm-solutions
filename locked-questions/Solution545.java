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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> results = new ArrayList();
        results.add(root.val);
        addLeft(root.left, results);
        // trick -> corner cases
        //          addLeaf could potentially add root again
        //          if not split into addLeaf(root.left) and addLeaf(root.right)
        addLeaf(root.left, results);
        addLeaf(root.right, results);
        addRight(root.right, results);
        return results;
    }

    private void addLeft(TreeNode node, List<Integer> results) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;

        results.add(node.val);
        if (node.left != null) {
            addLeft(node.left, results);
        } else if (node.right != null) {
            addLeft(node.right, results);
        }
    }

    private void addLeaf(TreeNode node, List<Integer> results) {
        if (node == null) return;
        if (node.left == null && node.right == null) results.add(node.val);

        addLeaf(node.left, results);
        addLeaf(node.right, results);
    }

      private void addRight(TreeNode node, List<Integer> results) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;

        if (node.right != null) {
            addRight(node.right, results);
        } else if (node.left != null) {
            addRight(node.left, results);
        }
        results.add(node.val);
    }
}