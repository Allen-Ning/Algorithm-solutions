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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }

    private Pair helper(TreeNode node) {
        if (node == null) return new Pair(null, -1);

        Pair left = helper(node.left);
        Pair right = helper(node.right);

        if (left.height > right.height) {
            left.height += 1;
            return left;
        } else if (left.height == right.height){
            return new Pair(node, left.height + 1);
        } else {
            right.height += 1;
            return right;
        }
    }

    class Pair {
        int height;
        TreeNode node;

        public Pair(TreeNode node, int height) {
            this.height = height;
            this.node = node;
        }
    }
}
