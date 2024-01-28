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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        /**
            dfs + level protection result
                    1
                2       3
            4     5

                  1
              2       3

                  1
              2       3
            4
         */
        List<Integer> result = new ArrayList();
        helper(result, root, 0);
        return result;
    }

    private void helper(List<Integer> result, TreeNode node, int level) {
        if (node == null) return;
        // trick -> here is the most tricky part of this question to find the most right node
        if (result.size() <= level) result.add(node.val);

        helper(result, node.right, level + 1);
        helper(result, node.left, level + 1);
    }
}