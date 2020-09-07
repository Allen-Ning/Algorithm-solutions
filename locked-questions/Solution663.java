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
    public boolean checkEqualTree(TreeNode root) {
        Set<Integer> set = new HashSet();
        int total = helper(root, set);
        return (total % 2 == 0) && set.contains(total / 2);
    }

    private int helper(TreeNode node, Set<Integer> set) {
        if (node == null) return 0;

        int value = node.val;
        int leftValue = helper(node.left, set);
        int rightValue = helper(node.right, set);
        set.add(node.val + leftValue);
        set.add(node.val + rightValue);

        return node.val + leftValue + rightValue;
    }
}
