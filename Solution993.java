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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] result = helper(root, x, y, null, 0);
        if (result == null) return false;
        return result[0] == 0 ? true : false;
    }

    private int[] helper(TreeNode node, int x, int y, TreeNode parent, int depth) {
        if (node == null) return null;
        if (node.val == x || node.val == y) return new int[] {parent == null ? -1 : parent.val, depth};

        int[] left = helper(node.left, x, y, node, depth + 1);
        int[] right = helper(node.right, x, y, node, depth + 1);
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null){
            return left;
        } else if (left[0] != right[0] && left[1] == right[1]) {
            return new int[] {0, left[1]};
        } else {
            return null;
        }
    }
}