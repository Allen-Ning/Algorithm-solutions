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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> list = new LinkedList();
        List<Double> results = new ArrayList();
        if (root == null) return results;

        list.add(root);
        while (!list.isEmpty()) {
            double result = 0;
            int size = list.size();
            for (int i = 0; i < size; i++) { 
                TreeNode node = list.poll();
                result += node.val;
                if (node.left != null) list.offer(node.left);
                if (node.right != null) list.offer(node.right);
            }
            results.add(result / size);  
        }
        return results;
    }
}
