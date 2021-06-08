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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        inOrder(root, list);
        return merge(list, 0, list.size() - 1);
    }

    private TreeNode merge(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = merge(list, start, mid - 1);
        node.right = merge(list, mid + 1, end);
        return node;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}