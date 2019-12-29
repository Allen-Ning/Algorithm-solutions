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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        List<Integer> result1 = new ArrayList();
        helper(root1, result1);

        List<Integer> result2 = new ArrayList();
        helper(root2, result2);

        if (result1.size() != result2.size()) return false;
        for (int i = 0; i < result1.size(); i++) {
            if (result1.get(i) != result2.get(i)) return false;
        }
        return true;
    }

    private TreeNode helper(TreeNode node, List<Integer> list) {
        if (node == null) return null;
        TreeNode left = helper(node.left, list);
        TreeNode right = helper(node.right, list);
        if (left == null && right == null) list.add(node.val);   
        return node;
    }
}
