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
    public int findClosestLeaf(TreeNode root, int k) {
        TreeNode[] map = new TreeNode[1001];
        int[] parents = new int[1001];
        helper(map, parents, k, root, null);

        Queue<Integer> queue = new LinkedList<Integer>();
        TreeNode target = map[k];
        if (target.left == null && target.right == null) return k;

        // trick -> don't forget the visited to make sure each node only visited once
        boolean[] visited = new boolean[1001];
        queue.offer(k);
        visited[k] = true;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                TreeNode node = map[value];
                if (node.left == null && node.right == null) return value;
                if (node.left != null && !visited[node.left.val]) {
                    queue.offer(node.left.val);
                    visited[node.left.val] = true;
                }
                if (node.right != null && !visited[node.right.val]) {
                    queue.offer(node.right.val);
                    visited[node.right.val] = true;
                }
                if (parents[node.val] > 0 && !visited[parents[node.val]]) {
                    queue.offer(parents[node.val]);
                    visited[parents[node.val]] = true;
                }
            }
        }
        return -1;
    }

    private void helper(TreeNode[] map, int[] parents, int k, TreeNode node, TreeNode parent) {
        if (node == null) return;

        if (parent != null) parents[node.val] = parent.val;
        map[node.val] = node;

        helper(map, parents, k, node.left, node);
        helper(map, parents, k, node.right, node);
    }
}
