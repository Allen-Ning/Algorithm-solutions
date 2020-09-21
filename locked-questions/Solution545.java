/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> lists = new ArrayList();
        if (root == null) return lists;

        lists.add(root.val);
        leftBoundary(root.left, lists);
        bottomBoundary(root.left, lists);
        bottomBoundary(root.right, lists);
        rightBoundary(root.right, lists);
        return lists;
    }

    private void leftBoundary(TreeNode node, List<Integer> lists) {
        if (node == null) return;

        if (node.left != null) {
            lists.add(node.val);
            leftBoundary(node.left, lists);
        } else if (node.right != null) {
            lists.add(node.val);
            leftBoundary(node.right, lists);
        }
    }

    private void rightBoundary(TreeNode node, List<Integer> lists) {
        if (node == null) return;

        // trick -> this is very smart move
        //          in order to get bottom up, and need to call rightBoundary() first and
        //          add node.val into lists during returning process
        if (node.right != null) {
            rightBoundary(node.right, lists);
            lists.add(node.val);
        } else if (node.left != null) {
            rightBoundary(node.left, lists);
            lists.add(node.val);
        }
    }

    private void bottomBoundary(TreeNode node, List<Integer> lists) {
        if (node == null) return;

        if (node.left == null && node.right == null) lists.add(node.val);
        bottomBoundary(node.left, lists);
        bottomBoundary(node.right, lists);
    }
}