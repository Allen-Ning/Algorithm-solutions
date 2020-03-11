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
    // preOrder  root     left      right
    //             (root, left right)
    // postOrder left     right     root
    //   (left right root)
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
      return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre, int l1, int r1, int[] post, int l2, int r2) {
      if (l1 == r1) return new TreeNode(pre[l1]);
      if (l1 > r1) return null;

      TreeNode node = new TreeNode(pre[l1]);
      int size = findLeftSize(post, pre[l1 + 1], l2, r2);

      node.left = helper(pre, l1 + 1, l1 + size, post, l2, l2 + size - 1);
      node.right = helper(pre, l1 + size + 1, r1, post, l2 + size, r2 - 1);
      return node;
    }

    private int findLeftSize(int[] post, int rootValue, int l, int r) {
      if (l == r) return 1;

      for (int i = l; l <= r; i++) {
        if (post[i] == rootValue) return i - l  + 1;
      }
      return 0;
    }
}

