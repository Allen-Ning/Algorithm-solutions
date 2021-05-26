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
    public double maximumAverageSubtree(TreeNode root) {
        double[] result = new double[] { 0.0 };
        int[] values = helper(root, result);
        return result[0];
    }

    private int[] helper(TreeNode node, double[] result) {
        if (node == null) return new int[] {0, 0};

        int[] leftValues = helper(node.left, result);
        int[] rightValues = helper(node.right, result);
        
        int[] returnedValues = new int[] {
            leftValues[0] + rightValues[0] + node.val,
            leftValues[1] + rightValues[1] + 1,
        };

        result[0] = Math.max((double) returnedValues[0] / (double) returnedValues[1], result[0]);
        return returnedValues;
    }
}
