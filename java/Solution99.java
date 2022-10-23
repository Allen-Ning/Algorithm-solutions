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

// 1 2 3 4 5 6 7 - good example 1

// 1 2 4 3 5 6 7 - bad exmaple 1
// 1 2 6 4 5 3 7 - bad exmaple 2
// 7 2 3 4 5 6 1 - bad exmaple 3

// Summary - binary tree inorder travel should  return ascending values (e.g. good example 1)
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> result = new ArrayList();
        TreeNode[] prev = new TreeNode[] { null };

        helper(root, result, prev);
        swop(result.get(0), result.get(1));
    }

    private void helper(TreeNode node, List<TreeNode> result, TreeNode[] prev) {
        if (node == null) return;

        helper(node.left, result, prev);

        if (prev[0] != null && node.val < prev[0].val) {
            if (result.size() == 0) {
                result.add(prev[0]);
                result.add(node);
            } else {
                result.set(1,node);
            }
        }
        prev[0] = node;
        helper(node.right, result, prev);
    }

    private void swop(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}