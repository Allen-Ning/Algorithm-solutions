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
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        helper(root, results);
        return results;
    }

    private int helper(TreeNode node, List<List<Integer>> results) {
        if (node == null) return -1;

        int levelLeft = helper(node.left, results);
        int levelRight = helper(node.right, results);

        int level = Math.max(levelLeft, levelRight) + 1;

        List<Integer> result = null;
        if (level < results.size()) {
            result = results.get(level);
        } else {
            result = new ArrayList<Integer>();
            results.add(result);
        }
        result.add(node.val);
        return level;
    }
}