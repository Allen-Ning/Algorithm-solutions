import java.util.*;

/**
 * Definition for binary tree
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class BSTIterator {
  private Stack<TreeNode> stack = new Stack<TreeNode>();

  public BSTIterator(TreeNode root) {
    TreeNode node = root;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {

    TreeNode node = stack.pop();
    TreeNode next  = node.right;
    while (next != null) {
      stack.push(next);
      next = next.left;
    }
    return node.val;
  }
}

