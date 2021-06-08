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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<String>();
        helper(root, new ArrayList<TreeNode>(), results);
        return results;
    }

    private void helper(TreeNode node, List<TreeNode> list, List<String> results) {
        if (node == null) return;

        list.add(node);
        if (node != null && node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).val);
                if (i != list.size() - 1) sb.append("->");
            }
            results.add(sb.toString());
        }
        helper(node.left, list, results);
        helper(node.right, list, results);
        list.remove(list.size() - 1);
        return;
    }
}
