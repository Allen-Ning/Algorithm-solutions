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
  public TreeNode deleteNode(TreeNode root, int key) {
    return helper(root, key);
  }

  private TreeNode findNode(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  private TreeNode helper(TreeNode node, int key) {
    if (node == null) return null;

    if (node.val > key) {
      node.left = helper(node.left, key);
    } else if (node.val < key) {
      node.right = helper(node.right, key);
    } else {
      if (node.left == null && node.right == null) {
        return null;
      } else if (node.left == null && node.right != null) {
        return node.right;
      } else if (node.left != null && node.right == null) {
        return node.left;
      } else if (node.left != null && node.right != null) {
        // trick -> find the most left node in the right subtree
        TreeNode foundNode = findNode(node.right);
        // trick -> delete the most left node in the right subtree and return the new node
        node = deleteNode(node, foundNode.val);
        // trick -> change the value of node to the deleted node value
        node.val = foundNode.val;
        return node;
      }
    }
    return node;
  }
}
