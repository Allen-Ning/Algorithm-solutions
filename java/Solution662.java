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
    public int widthOfBinaryTree(TreeNode root) {
       /**
            trick ->
            childIndex = parentIndex * 2 or parentIndex * 2 + 1
            max = (lastIndex - firstIndex + 1) in the same row
        */
        if (root == null) return 0;
        long result = 0;
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(root, 0L));

        while (queue.size() > 0) {
            int size = queue.size();
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Node data = queue.poll();
                TreeNode node = data.node;
                long index = data.index;

                min = Math.min(min, index);
                max = Math.max(max, index);

                if (node.left != null) {
                    queue.offer(new Node(node.left, index * 2));
                }
                if (node.right != null) {
                    queue.offer(new Node(node.right, index * 2 + 1));
                }
            }

            result = Math.max(max - min + 1, result);
        }
        return (int)result;
    }

    class Node {
        TreeNode node;
        long index;

        public Node(TreeNode node,long index) {
            this.node = node;
            this.index = index;
        }
    }
}
