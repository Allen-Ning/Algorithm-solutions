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
    // [8,5,1,7,10,12]
    // root left right
    public TreeNode bstFromPreorder(int[] preorder) {
      if (preorder == null || preorder.length == 0) return null;
      return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int l, int r) {
      if (l == r) return new TreeNode(preorder[l]);
      if (l > r) return null;

      TreeNode node = new TreeNode(preorder[l]);
      int size = findLeftSize(preorder, preorder[l], l + 1, r);
      node.left = helper(preorder, l + 1, l + size);
      node.right = helper(preorder, l + size + 1, r);
      return node;
    }

    private int findLeftSize(int[] preorder, int rootValue, int l, int r) {
      if (l > r) return 0;
      int i;
      for (i = l; i <= r; i++) {
        if (preorder[i] > rootValue) return i - l;
      }
      // trick -> this is special case like [4, 2]
      //          no right node
      return i - l;
    }
}
